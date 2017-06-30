package org.monitor.yarn.dao;

import org.monitor.yarn.domain.Data;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/27.
 */
public interface QueueFairSharedCountDao {
    void  insert(Date date) throws FileNotFoundException;
}
