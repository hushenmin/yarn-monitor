package org.monitor.yarn.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.monitor.yarn.jdbc.JDBCHelper;
import org.monitor.yarn.util.DateUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
public class JmxInfoDaoImpl implements JmxInfoDao {
    public List<JmxInfo> insert(Date date) {
            List<JmxInfo> jmxInfosList =null;
            List<JmxInfoTotalResource> jmxInfoTotalResourceList = null;


            InputStream in = null;
            try {
                //in = new URL(url).openStream();
                in = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\jmx.log"));


                JSONObject jsonObject = JSONObject.parseObject(IOUtils.toString(in));
                JSONArray jsonArray = jsonObject.getJSONArray("beans");
                jmxInfosList =  new ArrayList<JmxInfo>();
                jmxInfoTotalResourceList = new ArrayList<JmxInfoTotalResource>();
                String viewTime = DateUtils.formatTime(date);
                String viewDate = DateUtils.formatDate(date);

                for (Iterator interator = jsonArray.iterator(); interator.hasNext(); ) {
                    JSONObject object = (JSONObject) (interator.next());
                    JmxInfo jmxInfo = new JmxInfo();
                    if (null != object.getString("running_0") && null == object.getString("FairShareMB")) {
                        jmxInfo.setName(object.getString("name"));
                        jmxInfo.setModelerType(object.getString("modelerType"));
                        jmxInfo.setQueue(object.getString("tag.Queue"));
                        jmxInfo.setUser(object.getString("tag.User"));
                        jmxInfo.setContext(object.getString("tag.Context"));
                        jmxInfo.setHostname(object.getString("tag.Hostname"));
                        jmxInfo.setRunning_0(object.getString("running_0"));
                        jmxInfo.setRunning_60(object.getString("running_60"));
                        jmxInfo.setRunning_300(object.getString("running_300"));
                        jmxInfo.setRunning_1440(object.getString("running_1440"));
                        jmxInfo.setAppsSubmitted(object.getString("AppsSubmitted"));
                        jmxInfo.setAppsRunning(object.getString("AppsRunning"));
                        jmxInfo.setAppsPending(object.getString("AppsPending"));
                        jmxInfo.setAppsCompleted(object.getString("AppsCompleted"));
                        jmxInfo.setAppsKilled(object.getString("AppsFailed"));
                        jmxInfo.setAppsFailed(object.getString("AppsFailed"));
                        jmxInfo.setAllocatedMB(object.getString("AllocatedMB"));
                        jmxInfo.setAllocatedVCores(object.getString("AllocatedVCores"));
                        jmxInfo.setAllocatedContainers(object.getString("AllocatedContainers"));
                        jmxInfo.setAggregateContainersAllocated(object.getString("AggregateContainersAllocated"));
                        jmxInfo.setAggregateContainersReleased(object.getString("AggregateContainersReleased"));
                        jmxInfo.setAvailableMB(object.getString("AvailableMB"));
                        jmxInfo.setAvailableVCores(object.getString("AvailableVCores"));
                        jmxInfo.setPendingMB(object.getString("PendingMB"));
                        jmxInfo.setPendingVCores(object.getString("PendingVCores"));
                        jmxInfo.setPendingContainers(object.getString("PendingContainers"));
                        jmxInfo.setReservedMB(object.getString("ReservedMB"));
                        jmxInfo.setReservedVCores(object.getString("ReservedVCores"));
                        jmxInfo.setReservedContainers(object.getString("ReservedContainers"));
                        jmxInfo.setActiveUsers(object.getString("ActiveUsers"));
                        jmxInfo.setActiveApplications(object.getString("ActiveApplications"));
                        jmxInfo.setAppAttemptFirstContainerAllocationDelayNumOps(object.getString("AppAttemptFirstContainerAllocationDelayNumOps"));
                        jmxInfo.setAppAttemptFirstContainerAllocationDelayAvgTime(object.getString("AppAttemptFirstContainerAllocationDelayAvgTime"));
                        jmxInfosList.add(jmxInfo);
                        System.out.println(jmxInfo.toString());
                        String sql = "insert into jmxinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        Object [] params = new Object[]{
                                jmxInfo.getName(),
                                jmxInfo.getModelerType(),
                                jmxInfo.getQueue(),
                                jmxInfo.getUser(),
                                jmxInfo.getContext(),
                                jmxInfo.getHostname(),
                                jmxInfo.getRunning_0(),
                                jmxInfo.getRunning_60(),
                                jmxInfo.getRunning_300(),
                                jmxInfo.getRunning_1440(),
                                jmxInfo.getAppsSubmitted(),
                                jmxInfo.getAppsRunning(),
                                jmxInfo.getAppsPending(),
                                jmxInfo.getAppsCompleted(),
                                jmxInfo.getAppsKilled(),
                                jmxInfo.getAppsFailed(),
                                jmxInfo.getAllocatedMB(),
                                jmxInfo.getAllocatedVCores(),
                                jmxInfo.getAllocatedContainers(),
                                jmxInfo.getAggregateContainersAllocated(),
                                jmxInfo.getAggregateContainersReleased(),
                                jmxInfo.getAvailableMB(),
                                jmxInfo.getAvailableVCores(),
                                jmxInfo.getPendingMB(),
                                jmxInfo.getPendingVCores(),
                                jmxInfo.getPendingContainers(),
                                jmxInfo.getReservedMB(),
                                jmxInfo.getReservedVCores(),
                                jmxInfo.getReservedContainers(),
                                jmxInfo.getActiveUsers(),
                                jmxInfo.getActiveApplications(),
                                jmxInfo.getAppAttemptFirstContainerAllocationDelayNumOps(),
                                jmxInfo.getAppAttemptFirstContainerAllocationDelayAvgTime(),
                                viewTime,
                                viewDate
                        };
                        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
                        jdbcHelper.executeUpdate(sql,params);
                    }else if (null != object.getString("running_0") && null != object.getString("FairShareMB")){
                        JmxInfoTotalResource jmxInfoTotalResource  = new JmxInfoTotalResource();
                        jmxInfoTotalResource.setName(object.getString("name"));
                        jmxInfoTotalResource.setModelerType(object.getString("modelerType"));
                        jmxInfoTotalResource.setQueue(object.getString("tag.Queue"));
                        jmxInfoTotalResource.setContext(object.getString("tag.Context"));
                        jmxInfoTotalResource.setHostname(object.getString("tag.Hostname"));
                        jmxInfoTotalResource.setRunning_0(object.getString("running_0"));
                        jmxInfoTotalResource.setRunning_60(object.getString("running_60"));
                        jmxInfoTotalResource.setRunning_300(object.getString("running_300"));
                        jmxInfoTotalResource.setRunning_1440(object.getString("running_1440"));

                        jmxInfoTotalResource.setFairShareMB(object.getString("FairShareMB"));
                        jmxInfoTotalResource.setFairShareVCores(object.getString("FairShareVCores"));
                        jmxInfoTotalResource.setSteadyFairShareMB(object.getString("SteadyFairShareMB"));
                        jmxInfoTotalResource.setSteadyFairShareVCores(object.getString("SteadyFairShareVCores"));
                        jmxInfoTotalResource.setMinShareMB(object.getString("MinShareMB"));
                        jmxInfoTotalResource.setMinShareVCores(object.getString("MinShareVCores"));
                        jmxInfoTotalResource.setMaxShareMB(object.getString("MaxShareMB"));
                        jmxInfoTotalResource.setMaxShareVCores(object.getString("MaxShareVCores"));

                        jmxInfoTotalResource.setAppsSubmitted(object.getString("AppsSubmitted"));
                        jmxInfoTotalResource.setAppsRunning(object.getString("AppsRunning"));
                        jmxInfoTotalResource.setAppsPending(object.getString("AppsPending"));
                        jmxInfoTotalResource.setAppsCompleted(object.getString("AppsCompleted"));
                        jmxInfoTotalResource.setAppsKilled(object.getString("AppsFailed"));
                        jmxInfoTotalResource.setAppsFailed(object.getString("AppsFailed"));
                        jmxInfoTotalResource.setAllocatedMB(object.getString("AllocatedMB"));
                        jmxInfoTotalResource.setAllocatedVCores(object.getString("AllocatedVCores"));
                        jmxInfoTotalResource.setAllocatedContainers(object.getString("AllocatedContainers"));
                        jmxInfoTotalResource.setAggregateContainersAllocated(object.getString("AggregateContainersAllocated"));
                        jmxInfoTotalResource.setAggregateContainersReleased(object.getString("AggregateContainersReleased"));
                        jmxInfoTotalResource.setAvailableMB(object.getString("AvailableMB"));
                        jmxInfoTotalResource.setAvailableVCores(object.getString("AvailableVCores"));
                        jmxInfoTotalResource.setPendingMB(object.getString("PendingMB"));
                        jmxInfoTotalResource.setPendingVCores(object.getString("PendingVCores"));
                        jmxInfoTotalResource.setPendingContainers(object.getString("PendingContainers"));
                        jmxInfoTotalResource.setReservedMB(object.getString("ReservedMB"));
                        jmxInfoTotalResource.setReservedVCores(object.getString("ReservedVCores"));
                        jmxInfoTotalResource.setReservedContainers(object.getString("ReservedContainers"));
                        jmxInfoTotalResource.setActiveUsers(object.getString("ActiveUsers"));
                        jmxInfoTotalResource.setActiveApplications(object.getString("ActiveApplications"));
                        jmxInfoTotalResource.setAppAttemptFirstContainerAllocationDelayNumOps(object.getString("AppAttemptFirstContainerAllocationDelayNumOps"));
                        jmxInfoTotalResource.setAppAttemptFirstContainerAllocationDelayAvgTime(object.getString("AppAttemptFirstContainerAllocationDelayAvgTime"));
                        jmxInfoTotalResourceList.add(jmxInfoTotalResource);
                        System.out.println(jmxInfoTotalResource.toString());

                        String sql = "insert into jmxInfoTotalResource values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        Object [] params = new Object[]{
                                jmxInfoTotalResource.getName(),
                                jmxInfoTotalResource.getModelerType(),
                                jmxInfoTotalResource.getQueue(),

                                jmxInfoTotalResource.getContext(),
                                jmxInfoTotalResource.getHostname(),
                                jmxInfoTotalResource.getRunning_0(),
                                jmxInfoTotalResource.getRunning_60(),
                                jmxInfoTotalResource.getRunning_300(),
                                jmxInfoTotalResource.getRunning_1440(),


                                jmxInfoTotalResource.getFairShareMB(),
                                jmxInfoTotalResource.getFairShareVCores(),
                                jmxInfoTotalResource.getSteadyFairShareMB(),
                                jmxInfoTotalResource.getSteadyFairShareVCores(),
                                jmxInfoTotalResource.getMinShareMB(),
                                jmxInfoTotalResource.getMinShareVCores(),
                                jmxInfoTotalResource.getMaxShareMB(),
                                jmxInfoTotalResource.getMaxShareVCores(),

                                jmxInfoTotalResource.getAppsSubmitted(),
                                jmxInfoTotalResource.getAppsRunning(),
                                jmxInfoTotalResource.getAppsPending(),
                                jmxInfoTotalResource.getAppsCompleted(),
                                jmxInfoTotalResource.getAppsKilled(),
                                jmxInfoTotalResource.getAppsFailed(),
                                jmxInfoTotalResource.getAllocatedMB(),
                                jmxInfoTotalResource.getAllocatedVCores(),
                                jmxInfoTotalResource.getAllocatedContainers(),
                                jmxInfoTotalResource.getAggregateContainersAllocated(),
                                jmxInfoTotalResource.getAggregateContainersReleased(),
                                jmxInfoTotalResource.getAvailableMB(),
                                jmxInfoTotalResource.getAvailableVCores(),
                                jmxInfoTotalResource.getPendingMB(),
                                jmxInfoTotalResource.getPendingVCores(),
                                jmxInfoTotalResource.getPendingContainers(),
                                jmxInfoTotalResource.getReservedMB(),
                                jmxInfoTotalResource.getReservedVCores(),
                                jmxInfoTotalResource.getReservedContainers(),
                                jmxInfoTotalResource.getActiveUsers(),
                                jmxInfoTotalResource.getActiveApplications(),
                                jmxInfoTotalResource.getAppAttemptFirstContainerAllocationDelayNumOps(),
                                jmxInfoTotalResource.getAppAttemptFirstContainerAllocationDelayAvgTime(),
                                viewTime,
                                viewDate
                        };
                        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
                        jdbcHelper.executeUpdate(sql,params);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        return null;

    }

}
