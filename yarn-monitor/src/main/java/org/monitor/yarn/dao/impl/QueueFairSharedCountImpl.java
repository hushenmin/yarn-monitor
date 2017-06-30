package org.monitor.yarn.dao.impl;

import org.monitor.yarn.constant.ResourceStyle;
import org.monitor.yarn.dao.QueueFairSharedCountDao;
import org.monitor.yarn.dao.impl.common.FetchJmx2SQL;
import org.monitor.yarn.dao.impl.common.FetchJmxFairSharedJson2SQL;
import org.monitor.yarn.jdbc.JDBCHelper;
import org.monitor.yarn.util.DateUtils;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/27.
 */
public class QueueFairSharedCountImpl implements QueueFairSharedCountDao {
    @Override
    public void insert(Date date) throws FileNotFoundException {
        Object toJSON = FetchJmxFairSharedJson2SQL.Jmx2SQL(date);


        String viewTime = DateUtils.formatTime(date);
        String viewDate = DateUtils.formatDate(date);

        String sql = "insert into queuefairsharedcountjson values(?,?,?,?)";
        Object[] params = new Object[]{
                0,
                toJSON.toString(),
                viewTime,
                viewDate
        };

        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        jdbcHelper.executeUpdate(sql,params);

    }
}
