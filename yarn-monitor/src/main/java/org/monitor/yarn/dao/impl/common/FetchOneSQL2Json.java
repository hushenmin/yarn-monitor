package org.monitor.yarn.dao.impl.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.monitor.yarn.domain.QueueUsedCount;
import org.monitor.yarn.jdbc.JDBCHelper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.monitor.yarn.domain.Data;
import org.monitor.yarn.domain.QueueUsedCount;
import org.monitor.yarn.jdbc.JDBCHelper;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.alibaba.fastjson.JSON.toJSON;

/**
 * Created by Administrator on 2017/6/22.
 */
public class FetchOneSQL2Json {
    public static Object callOneMessage(String sql){
    JDBCHelper jdbcHelper = JDBCHelper.getInstance();
    final Map<String,Map<String,Long>> parent = new TreeMap<String, Map<String,Long>>();
    Object json = null;
    jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {
        @Override
        public void process(ResultSet rs) throws Exception {
            String queue = null;
            while(rs.next()) {
                String str = rs.getString(2);
                List<QueueUsedCount> jsonObject = JSONObject.parseArray(str, QueueUsedCount.class);
                for (int i = 0; i <jsonObject.size() ; i++) {
                    Map<String,Long> child = null;
                    queue = jsonObject.get(i).getName();
                    for (int j = 0; j < jsonObject.get(i).getData().size(); j++) {
                        child = new TreeMap<String, Long>();
                        Long x = jsonObject.get(i).getData().get(j).getX();
                        Long y = jsonObject.get(i).getData().get(j).getY();
                        child.put("x",x);
                        child.put("y",y);
                    }
                    parent.put(queue,child);
                }

            }
        }

    });
    //json = JSON.toJSONString(parent);
    //System.out.println(json.toString());
        return   JSONObject.toJSON(parent);

    }
}
