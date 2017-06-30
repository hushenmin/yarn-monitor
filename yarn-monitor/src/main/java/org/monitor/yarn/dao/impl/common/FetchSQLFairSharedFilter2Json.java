package org.monitor.yarn.dao.impl.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.monitor.yarn.constant.Constants;
import org.monitor.yarn.constant.ResourceStyle;
import org.monitor.yarn.domain.*;
import org.monitor.yarn.jdbc.JDBCHelper;

import java.sql.ResultSet;
import java.util.*;

/**
 * Created by Administrator on 2017/6/28.
 */
public class FetchSQLFairSharedFilter2Json {

    public static Object SQL2JSON(String sql, String date, final  ResourceStyle style) {

        JDBCHelper jdbcHelper = JDBCHelper.getInstance();

        final FairParent fairParent = new FairParent();

        final Map<String,ArrayList<Long>> maxValueMap = new TreeMap<String, ArrayList<Long>>();

        final Map<String,ArrayList<Long>> usedValueMap = new TreeMap<String, ArrayList<Long>>();

        final Map<String,DataSets> datasetMap = new TreeMap<String,DataSets>();
        final  ArrayList<DataSets> dataSetsList =  new ArrayList<DataSets>();
        final  ArrayList<Long> timeStampList =  new ArrayList<Long>();
        jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {

            @Override
            public void process(ResultSet rs) throws Exception {
                String queue = null;
                while (rs.next()) {
                    String str = rs.getString(2);
                    Boolean flag = true;
                    List<QueueFairShared> jsonObject = JSONObject.parseArray(str, QueueFairShared.class);
                    for (int i = 0; i < jsonObject.size(); i++) {
                       queue =  jsonObject.get(i).getQueue();
                        if(maxValueMap.get(queue)== null && usedValueMap.get(queue) == null){
                            maxValueMap.put(queue,new ArrayList<Long>());
                            usedValueMap.put(queue,new ArrayList<Long>());
                        }
                        switch (style) {
                            case MEMORY:
                                maxValueMap.get(queue).add(Long.valueOf(jsonObject.get(i).getMem().getFair())/1024);
                                usedValueMap.get(queue).add(Long.valueOf(jsonObject.get(i).getMem().getUsed())/1024);
                                break;
                            case CPU:
                                maxValueMap.get(queue).add(Long.valueOf(jsonObject.get(i).getCpu().getFair()));
                                usedValueMap.get(queue).add(Long.valueOf(jsonObject.get(i).getCpu().getUsed()));
                                break;
                        }
                        FairUsed fairUsed = new FairUsed();
                        fairUsed.setQueue(queue);
                        fairUsed.setUsedData(usedValueMap.get(queue));

                        DataSets dataSets = datasetMap.get(queue);
                        if(dataSets == null) {
                            dataSets = new DataSets();
                            datasetMap.put(queue,dataSets);
                        }
                        dataSets.setName("MaxSharedValue");
                        dataSets.setMaxValue(maxValueMap.get(queue));
                        dataSets.setUsedValues(fairUsed);
                        if(flag){
                            timeStampList.add(Long.valueOf(jsonObject.get(i).getTimeStamp()));
                            flag = false;
                        }
                    }
                }
            }
        });

        for (Map.Entry<String, DataSets> entry : datasetMap.entrySet()){
            dataSetsList.add(entry.getValue());
        }
        fairParent.setxData(timeStampList);
        fairParent.setDatasets(dataSetsList);
        //System.out.println(JSON.toJSON(fairParent).toString());
         return   JSONObject.toJSON(fairParent);
    }

}
