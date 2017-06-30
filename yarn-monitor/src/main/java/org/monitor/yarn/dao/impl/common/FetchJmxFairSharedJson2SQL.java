package org.monitor.yarn.dao.impl.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.monitor.yarn.conf.PropertyFetcher;
import org.monitor.yarn.constant.Constants;
import org.monitor.yarn.domain.*;
import org.monitor.yarn.util.DateUtils;
import org.monitor.yarn.util.NodeParseUtils;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * Created by Administrator on 2017/6/27.
 */
public class FetchJmxFairSharedJson2SQL {
    public static Object Jmx2SQL(Date date)  {
        String timeStamp = DateUtils.formatTimeStamp(date);
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

       // in = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\jmx.log"));
        try {
            jsonObject = JSONObject.parseObject(IOUtils.toString(in));
        }catch (Exception e){
            e.printStackTrace();
        }

        JSONArray jsonArray = jsonObject.getJSONArray("beans");

        NodeParseUtils nodeParseUtils =null;
        //String root = null;
        HashSet set = new HashSet();
        List<QueueFairShared>  queueList = new ArrayList<QueueFairShared>();

        /**
         * 循环遍历各个队列的资源使用情况并且将所有的队列的资源使用信息转换成json格式。
         */
        for (Iterator interator = jsonArray.iterator(); interator.hasNext();) {
            JSONObject object = (JSONObject) (interator.next());
            if (null == object.getString("tag.User") && null != object.getString("running_0") && null != object.getString("FairShareMB")) {
                QueueFairShared queueFairShared = new QueueFairShared();
                Cpu cpu = new Cpu();
                Mem mem = new Mem();
                String queue = object.getString("tag.Queue");
                nodeParseUtils = new NodeParseUtils(queue);
                if(!nodeParseUtils.hasChild(set) || nodeParseUtils.isRoot()){
                    mem.setFair(object.getString("FairShareMB"));
                    mem.setUsed(object.getString("AllocatedMB"));
                    cpu.setFair(object.getString("FairShareVCores"));
                    cpu.setUsed(object.getString("AllocatedVCores"));
                    queueFairShared.setCpu(cpu);
                    queueFairShared.setMem(mem);
                    queueFairShared.setTimeStamp(timeStamp);
                    queueFairShared.setQueue(queue);
                    queueList.add(queueFairShared);
                }
            }
        }

        toJSON = JSON.toJSON(queueList);

        //System.out.println(toJSON.toString());
        return  toJSON;
    }

}
