package org.monitor.yarn.dao;

import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2017/6/22.
 */
public interface QueueCpuUsedJsonDao {
    JSON callMessage(int limit);
    Object callOneMessage();
}
