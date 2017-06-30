package org.monitor.yarn.dao.factory;

import org.monitor.yarn.dao.*;
import org.monitor.yarn.dao.impl.*;

/**
 * Created by Administrator on 2017/6/19.
 */
public class DaoFactory {
    public static QueueCpuUsedCountDao getQueueCpuUsedCountDao(){return  new QueueCpuUsedCountImpl();}
    public static QueueMemUsedCountDao getQueueMemUsedCountDao(){return  new QueueMemUsedCountImpl();}
    public static QueueMemUsedJsonDao getMemUsedJsonDao(){return  new QueueMemUsedJsonImpl();}
    public  static QueueCpuUsedJsonDao getCpuUsedJsonDao(){return  new QueueCpuUsedJsonImpl();}
    public static  QueueFairSharedCountDao getFairSharedCountDao(){return new QueueFairSharedCountImpl();}
    public  static FetchSQLFairSharedFilter2JsonDao getFetchSQLFairSharedFilter2JsonDao(){return  new FetchSQLFairSharedFilter2JsonImpl();}
}
