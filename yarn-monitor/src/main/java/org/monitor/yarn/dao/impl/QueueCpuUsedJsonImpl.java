package org.monitor.yarn.dao.impl;

import com.alibaba.fastjson.JSON;
import org.monitor.yarn.dao.QueueCpuUsedCountDao;
import org.monitor.yarn.dao.QueueCpuUsedJsonDao;
import org.monitor.yarn.dao.impl.common.FetchOneSQL2Json;
import org.monitor.yarn.dao.impl.common.FetchSQLFilter2Json;
import org.monitor.yarn.util.DateUtils;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/22.
 */
public class QueueCpuUsedJsonImpl implements QueueCpuUsedJsonDao {

    @Override
    public JSON callMessage(int limit) {
        String date = DateUtils.getDateBefore(limit);
        String sql = "SELECT * FROM (SELECT *  FROM  QueueCpuUsedCountJson WHERE viewdate >=\"" + date + "\" ORDER BY id desc ) t ORDER BY id;";
       // System.out.println(FetchSQLFilter2Json.SQL2JSON(sql,date).toJSONString());
        return FetchSQLFilter2Json.SQL2JSON(sql,date);
    }
    @Override
    public Object callOneMessage() {
        String sql = "SELECT * FROM (SELECT *  FROM  queuecpuusedcountjson ORDER BY id desc limit 1) t ORDER BY id;";
        return  FetchOneSQL2Json.callOneMessage(sql);
    }

    public static void main(String[] args) {
        QueueCpuUsedJsonImpl queueCpuUsedJson = new QueueCpuUsedJsonImpl();
        queueCpuUsedJson.callMessage(1);
    }
}
