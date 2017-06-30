package org.monitor.yarn.dao;

import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2017/6/20.
 */
public interface QueueMemUsedJsonDao {
    JSON callMessage(int limit);
    Object callOneMessage();
}
