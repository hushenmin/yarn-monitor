package org.monitor.yarn.dao;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/14.
 */
public interface QueueCpuUsedCountDao {
    void insert(Date date);
}
