package org.monitor.yarn.test;

/**
 * Created by Administrator on 2017/6/14.
 */
public class JmxInfo {
    private String name;
    private String modelerType;
    private String Queue;
    private String User;
    private String Context;
    private String Hostname;
    private String running_0;
    private String running_60;
    private String running_300;
    private String running_1440;
    private String AppsSubmitted;
    private String AppsRunning;
    private String AppsPending;
    private String AppsCompleted;
    private String AppsKilled;
    private String AppsFailed;
    private String AllocatedMB;
    private String AllocatedVCores;
    private String AllocatedContainers;
    private String AggregateContainersAllocated;
    private String AggregateContainersReleased;
    private String AvailableMB;
    private String AvailableVCores;
    private String PendingMB;
    private String PendingVCores;
    private String PendingContainers;
    private String ReservedMB;
    private String ReservedVCores;
    private String ReservedContainers;
    private String ActiveUsers;
    private String ActiveApplications;
    private String AppAttemptFirstContainerAllocationDelayNumOps;
    private String AppAttemptFirstContainerAllocationDelayAvgTime;


    public String getAppAttemptFirstContainerAllocationDelayAvgTime() {
        return AppAttemptFirstContainerAllocationDelayAvgTime;
    }

    public void setAppAttemptFirstContainerAllocationDelayAvgTime(String appAttemptFirstContainerAllocationDelayAvgTime) {
        AppAttemptFirstContainerAllocationDelayAvgTime = appAttemptFirstContainerAllocationDelayAvgTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelerType() {
        return modelerType;
    }

    public void setModelerType(String modelerType) {
        this.modelerType = modelerType;
    }

    public String getQueue() {
        return Queue;
    }

    public void setQueue(String queue) {
        Queue = queue;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public String getHostname() {
        return Hostname;
    }

    public void setHostname(String hostname) {
        Hostname = hostname;
    }

    public String getRunning_0() {
        return running_0;
    }

    public void setRunning_0(String running_0) {
        this.running_0 = running_0;
    }

    public String getRunning_60() {
        return running_60;
    }

    public void setRunning_60(String running_60) {
        this.running_60 = running_60;
    }

    public String getRunning_300() {
        return running_300;
    }

    public void setRunning_300(String running_300) {
        this.running_300 = running_300;
    }

    public String getRunning_1440() {
        return running_1440;
    }

    public void setRunning_1440(String running_1440) {
        this.running_1440 = running_1440;
    }

    public String getAppsSubmitted() {
        return AppsSubmitted;
    }

    public void setAppsSubmitted(String appsSubmitted) {
        AppsSubmitted = appsSubmitted;
    }

    public String getAppsRunning() {
        return AppsRunning;
    }

    public void setAppsRunning(String appsRunning) {
        AppsRunning = appsRunning;
    }

    public String getAppsPending() {
        return AppsPending;
    }

    public void setAppsPending(String appsPending) {
        AppsPending = appsPending;
    }

    public String getAppsCompleted() {
        return AppsCompleted;
    }

    public void setAppsCompleted(String appsCompleted) {
        AppsCompleted = appsCompleted;
    }

    public String getAppsKilled() {
        return AppsKilled;
    }

    public void setAppsKilled(String appsKilled) {
        AppsKilled = appsKilled;
    }

    public String getAppsFailed() {
        return AppsFailed;
    }

    public void setAppsFailed(String appsFailed) {
        AppsFailed = appsFailed;
    }

    public String getAllocatedMB() {
        return AllocatedMB;
    }

    public void setAllocatedMB(String allocatedMB) {
        AllocatedMB = allocatedMB;
    }

    public String getAllocatedVCores() {
        return AllocatedVCores;
    }

    public void setAllocatedVCores(String allocatedVCores) {
        AllocatedVCores = allocatedVCores;
    }

    public String getAllocatedContainers() {
        return AllocatedContainers;
    }

    public void setAllocatedContainers(String allocatedContainers) {
        AllocatedContainers = allocatedContainers;
    }

    public String getAggregateContainersAllocated() {
        return AggregateContainersAllocated;
    }

    public void setAggregateContainersAllocated(String aggregateContainersAllocated) {
        AggregateContainersAllocated = aggregateContainersAllocated;
    }

    public String getAggregateContainersReleased() {
        return AggregateContainersReleased;
    }

    public void setAggregateContainersReleased(String aggregateContainersReleased) {
        AggregateContainersReleased = aggregateContainersReleased;
    }

    public String getAvailableMB() {
        return AvailableMB;
    }

    public void setAvailableMB(String availableMB) {
        AvailableMB = availableMB;
    }

    public String getAvailableVCores() {
        return AvailableVCores;
    }

    public void setAvailableVCores(String availableVCores) {
        AvailableVCores = availableVCores;
    }

    public String getPendingMB() {
        return PendingMB;
    }

    public void setPendingMB(String pendingMB) {
        PendingMB = pendingMB;
    }

    public String getPendingVCores() {
        return PendingVCores;
    }

    public void setPendingVCores(String pendingVCores) {
        PendingVCores = pendingVCores;
    }

    public String getPendingContainers() {
        return PendingContainers;
    }

    public void setPendingContainers(String pendingContainers) {
        PendingContainers = pendingContainers;
    }

    public String getReservedMB() {
        return ReservedMB;
    }

    public void setReservedMB(String reservedMB) {
        ReservedMB = reservedMB;
    }

    public String getReservedVCores() {
        return ReservedVCores;
    }

    public void setReservedVCores(String reservedVCores) {
        ReservedVCores = reservedVCores;
    }

    public String getReservedContainers() {
        return ReservedContainers;
    }

    public void setReservedContainers(String reservedContainers) {
        ReservedContainers = reservedContainers;
    }

    public String getActiveUsers() {
        return ActiveUsers;
    }

    public void setActiveUsers(String activeUsers) {
        ActiveUsers = activeUsers;
    }

    public String getActiveApplications() {
        return ActiveApplications;
    }

    public void setActiveApplications(String activeApplications) {
        ActiveApplications = activeApplications;
    }

    public String getAppAttemptFirstContainerAllocationDelayNumOps() {
        return AppAttemptFirstContainerAllocationDelayNumOps;
    }

    public void setAppAttemptFirstContainerAllocationDelayNumOps(String appAttemptFirstContainerAllocationDelayNumOps) {
        AppAttemptFirstContainerAllocationDelayNumOps = appAttemptFirstContainerAllocationDelayNumOps;
    }

    @Override
    public String toString() {
        return "JmxInfo{" +
                "name='" + name + '\'' +
                ", modelerType='" + modelerType + '\'' +
                ", Queue='" + Queue + '\'' +
                ", User='" + User + '\'' +
                ", Context='" + Context + '\'' +
                ", Hostname='" + Hostname + '\'' +
                ", running_0='" + running_0 + '\'' +
                ", running_60='" + running_60 + '\'' +
                ", running_300='" + running_300 + '\'' +
                ", running_1440='" + running_1440 + '\'' +
                ", AppsSubmitted='" + AppsSubmitted + '\'' +
                ", AppsRunning='" + AppsRunning + '\'' +
                ", AppsPending='" + AppsPending + '\'' +
                ", AppsCompleted='" + AppsCompleted + '\'' +
                ", AppsKilled='" + AppsKilled + '\'' +
                ", AppsFailed='" + AppsFailed + '\'' +
                ", AllocatedMB='" + AllocatedMB + '\'' +
                ", AllocatedVCores='" + AllocatedVCores + '\'' +
                ", AllocatedContainers='" + AllocatedContainers + '\'' +
                ", AggregateContainersAllocated='" + AggregateContainersAllocated + '\'' +
                ", AggregateContainersReleased='" + AggregateContainersReleased + '\'' +
                ", AvailableMB='" + AvailableMB + '\'' +
                ", AvailableVCores='" + AvailableVCores + '\'' +
                ", PendingMB='" + PendingMB + '\'' +
                ", PendingVCores='" + PendingVCores + '\'' +
                ", PendingContainers='" + PendingContainers + '\'' +
                ", ReservedMB='" + ReservedMB + '\'' +
                ", ReservedVCores='" + ReservedVCores + '\'' +
                ", ReservedContainers='" + ReservedContainers + '\'' +
                ", ActiveUsers='" + ActiveUsers + '\'' +
                ", ActiveApplications='" + ActiveApplications + '\'' +
                ", AppAttemptFirstContainerAllocationDelayNumOps='" + AppAttemptFirstContainerAllocationDelayNumOps + '\'' +
                ", AppAttemptFirstContainerAllocationDelayAvgTime='" + AppAttemptFirstContainerAllocationDelayAvgTime + '\'' +
                '}';
    }
}
