package org.monitor.yarn.dao;

/**
 * Created by Administrator on 2017/6/28.
 */
public interface FetchSQLFairSharedFilter2JsonDao {
    Object callAllMemMessage(int limit);
    Object callAllCpuMessage(int limit);
}
