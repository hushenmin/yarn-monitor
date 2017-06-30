package org.monitor.yarn.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.monitor.yarn.conf.PropertyFetcher;
import org.monitor.yarn.constant.Constants;
import org.monitor.yarn.dao.QueueMemUsedJsonDao;
import org.monitor.yarn.dao.impl.common.FetchOneSQL2Json;
import org.monitor.yarn.dao.impl.common.FetchSQLFilter2Json;
import org.monitor.yarn.domain.Data;
import org.monitor.yarn.domain.QueueUsedCount;
import org.monitor.yarn.jdbc.JDBCHelper;
import org.monitor.yarn.util.DateUtils;

import java.sql.ResultSet;
import java.util.*;

/**
 * Created by Administrator on 2017/6/20.
 */
public class QueueMemUsedJsonImpl implements QueueMemUsedJsonDao {

    @Override
    public JSON callMessage(int limit) {
        String date = DateUtils.getDateBefore(PropertyFetcher.getInt(Constants.CHART_REALTIME_DAYS_AGO_LIMIT));
        String sql = "SELECT * FROM (SELECT *  FROM  QueueMemUsedCountJson WHERE viewdate >=\"" + date + "\" ORDER BY id desc ) t ORDER BY id;";
        return FetchSQLFilter2Json.SQL2JSON(sql,date);
    }

    @Override
    public Object callOneMessage() {
        String sql = "SELECT * FROM (SELECT *  FROM  queuememusedcountjson ORDER BY id desc limit 1) t ORDER BY id;";
        return  FetchOneSQL2Json.callOneMessage(sql);
    }

    public static void main(String[] args) {
        QueueMemUsedJsonImpl queueMemUsedJson = new QueueMemUsedJsonImpl();
        queueMemUsedJson.callMessage(10);
    }
}


