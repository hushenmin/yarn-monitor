package org.monitor.yarn.dao.impl.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.monitor.yarn.domain.Data;
import org.monitor.yarn.domain.QueueUsedCount;
import org.monitor.yarn.jdbc.JDBCHelper;
import org.monitor.yarn.util.DateUtils;

import java.sql.ResultSet;
import java.util.*;

/**
 * Created by Administrator on 2017/6/21.
 */
public class FetchSQLFilter2Json {

    public static JSON SQL2JSON(String sql,String date) {


        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        final Map<String,QueueUsedCount> memUsedCountMap =  new TreeMap<String, QueueUsedCount>();
        jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {

            @Override
            public void process(ResultSet rs) throws Exception {
                String queue = null;
                while(rs.next()) {
                    String str = rs.getString(2);
                    List<QueueUsedCount> jsonObject = JSONObject.parseArray(str, QueueUsedCount.class);
                    for (int i = 0; i <jsonObject.size() ; i++) {

                        QueueUsedCount queueUsedCount =  new QueueUsedCount();
                        queue = jsonObject.get(i).getName();

                        if(null == memUsedCountMap.get(queue)){
                            memUsedCountMap.put(queue, queueUsedCount);
                        }
                        queueUsedCount =  memUsedCountMap.get(queue);

                        for (int j = 0; j < jsonObject.get(i).getData().size(); j++) {
                            Data data = new Data();
                            Long x = jsonObject.get(i).getData().get(j).getX();
                            Long y = jsonObject.get(i).getData().get(j).getY();
                            data.setX(x);
                            data.setY(y);
                            queueUsedCount.addData(data);
                        }
                        queueUsedCount.setName(queue);
                        memUsedCountMap.put(queue, queueUsedCount);
                    }
                }
            }
        });
        Boolean flag = false;
        StringBuilder str =  new StringBuilder();
        for (Map.Entry<String, QueueUsedCount> entry : memUsedCountMap.entrySet()) {
            if(false == flag){
                str.append("[" +JSON.toJSON(entry.getValue()).toString());
                flag = true;
            }else{
                str.append(","+JSON.toJSON(entry.getValue()).toString());
            }
        }
        str.append("]");
        //System.out.println(str);
        return  JSON.parseArray(str.toString());

    }

}
