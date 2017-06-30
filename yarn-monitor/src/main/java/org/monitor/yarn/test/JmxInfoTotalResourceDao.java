package org.monitor.yarn.test;

import org.monitor.yarn.test.JmxInfoTotalResource;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */
public interface JmxInfoTotalResourceDao {
    List<JmxInfoTotalResource> getJmxInfoTotalResource(Date date );

}
