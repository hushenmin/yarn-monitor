package org.monitor.yarn.dao.impl.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.monitor.yarn.conf.PropertyFetcher;
import org.monitor.yarn.constant.Constants;
import org.monitor.yarn.constant.ResourceStyle;
import org.monitor.yarn.domain.Data;
import org.monitor.yarn.domain.QueueUsedCount;
import org.monitor.yarn.util.DateUtils;
import org.monitor.yarn.util.NodeParseUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.*;

import static org.monitor.yarn.constant.ResourceStyle.CPU;
import static org.monitor.yarn.constant.ResourceStyle.MEMORY;

/**
 * Created by Administrator on 2017/6/22.
 */
public  class FetchJmx2SQL {
     public static Object Jmx2SQL(Date date , ResourceStyle style){
       String timeStamp = DateUtils.formatTimeStamp(date);
       String resourceStr =null;

       switch (style) {
           case CPU:
               resourceStr = Constants.CPU;
               break;
           case MEMORY:
               resourceStr = Constants.MEMEORY;
               break;
       }
       Object  toJSON =null;
       InputStream in = null;
       String url= null;
       JSONObject jsonObject = null;
       try {
           url = PropertyFetcher.getProperty(Constants.YARN_RM_ACTIVE);
           in = new URL(url).openStream();
       } catch (Exception e) {
           url = PropertyFetcher.getProperty(Constants.YARN_RM_STANDBY);
           try {
               in = new URL(url).openStream();
           }catch (Exception ex){
               System.out.println("Yarn address is invalid");
               ex.printStackTrace();
           }
       }
       //in = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\jmx.log"));
       try {
           jsonObject = JSONObject.parseObject(IOUtils.toString(in));
       }catch (Exception e){
           e.printStackTrace();
       }

       JSONArray jsonArray = jsonObject.getJSONArray("beans");

       NodeParseUtils nodeParseUtils =null;
       String root = null;
       HashSet set = new HashSet();
       List<QueueUsedCount> queueUsedCountList = new ArrayList<QueueUsedCount>();

       //获取root队列的内存。
       for (Iterator interator = jsonArray.iterator(); interator.hasNext();) {
           JSONObject object = (JSONObject) (interator.next());

           if (null != object.getString("running_0") && null != object.getString(resourceStr) && null != object.getString("FairShareMB")) {

               String queue = object.getString("tag.Queue");
               //System.out.println(queue);
               nodeParseUtils = new NodeParseUtils(queue);
               set.add(queue);
               if (nodeParseUtils.isRoot()) {
                   root = object.getString(resourceStr);
                   System.out.println(root);
               }
           }
       }

       /**
        * 循环遍历各个队列的资源使用情况并且将所有的队列的资源使用信息转换成json格式。
        */
       for (Iterator interator = jsonArray.iterator(); interator.hasNext();) {
           JSONObject object = (JSONObject) (interator.next());
           if (null != object.getString("running_0") && null != object.getString(resourceStr)&&null != object.getString("FairShareMB")) {
               QueueUsedCount queueUsedCount = new QueueUsedCount();
               Data data = new Data();
               String queue = object.getString("tag.Queue");
               nodeParseUtils = new NodeParseUtils(queue);
               if(!nodeParseUtils.hasChild(set) || nodeParseUtils.isRoot()){
                   queueUsedCount.setName(queue);
                   data.setX(Long.valueOf(timeStamp));
                   data.setY(object.getLong(resourceStr));
                   queueUsedCount.addData(data);
                   queueUsedCountList.add(queueUsedCount);
               }
           }
       }

       toJSON = JSON.toJSON(queueUsedCountList);

       System.out.println(toJSON);
         return  toJSON;
    }
}
