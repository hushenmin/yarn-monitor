drop table IF EXISTS  yarn.jmxinfo;
CREATE  TABLE if NOT  EXISTS yarn.jmxinfo(
name VARCHAR (500),
modelerType VARCHAR(100),
Queue  varchar(100),
User  varchar(20),
Context  varchar(20),
Hostname  varchar(100),
running_0  varchar(20),
running_60  varchar(20),
running_300  varchar(20),
running_1440  varchar(20),
AppsSubmitted  varchar(20),
AppsRunning  varchar(20),
AppsPending  varchar(20),
AppsCompleted  varchar(20),
AppsKilled  varchar(20),
AppsFailed  varchar(20),
AllocatedMB  varchar(20),
AllocatedVCores  varchar(20),
AllocatedContainers  varchar(20),
AggregateContainersAllocated  varchar(20),
AggregateContainersReleased  varchar(20),
AvailableMB  varchar(20),
AvailableVCores  varchar(20),
PendingMB  varchar(20),
PendingVCores  varchar(20),
PendingContainers  varchar(20),
ReservedMB  varchar(20),
ReservedVCores  varchar(20),
ReservedContainers  varchar(20),
ActiveUsers  varchar(20),
ActiveApplications  varchar(20),
AppAttemptFirstContainerAllocationDelayNumOps  varchar(20),
AppAttemptFirstContainerAllocationDelayAvgTime  varchar(20),
viewtime VARCHAR (20),
viewdate VARCHAR(20)
)