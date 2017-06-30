package org.monitor.yarn.dao;

import com.alibaba.fastjson.JSON;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
public interface QueueMemUsedCountDao {
      void insert(Date date);
}
