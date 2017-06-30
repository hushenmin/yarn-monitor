package org.monitor.yarn.dao.impl;

import com.alibaba.fastjson.JSON;
import org.monitor.yarn.conf.PropertyFetcher;
import org.monitor.yarn.constant.Constants;
import org.monitor.yarn.constant.ResourceStyle;
import org.monitor.yarn.dao.FetchSQLFairSharedFilter2JsonDao;
import org.monitor.yarn.dao.impl.common.FetchSQLFairSharedFilter2Json;
import org.monitor.yarn.dao.impl.common.FetchSQLFilter2Json;
import org.monitor.yarn.util.DateUtils;

/**
 * Created by Administrator on 2017/6/28.
 */
public class FetchSQLFairSharedFilter2JsonImpl implements FetchSQLFairSharedFilter2JsonDao {
    @Override
    public Object callAllMemMessage(int limit) {
        String date = DateUtils.getDateBefore(PropertyFetcher.getInt(Constants.CHART_REALTIME_DAYS_AGO_LIMIT));
        String sql = "SELECT * FROM (SELECT *  FROM  queuefairsharedcountjson WHERE viewdate >=\"" + date + "\" ORDER BY id desc ) t ORDER BY id;";
        return FetchSQLFairSharedFilter2Json.SQL2JSON(sql,date, ResourceStyle.MEMORY);    }

    @Override
    public Object callAllCpuMessage(int limit) {
        String date = DateUtils.getDateBefore(PropertyFetcher.getInt(Constants.CHART_REALTIME_DAYS_AGO_LIMIT));
        String sql = "SELECT * FROM (SELECT *  FROM  queuefairsharedcountjson WHERE viewdate >=\"" + date + "\" ORDER BY id desc ) t ORDER BY id;";
        return FetchSQLFairSharedFilter2Json.SQL2JSON(sql,date, ResourceStyle.CPU);    }
}
