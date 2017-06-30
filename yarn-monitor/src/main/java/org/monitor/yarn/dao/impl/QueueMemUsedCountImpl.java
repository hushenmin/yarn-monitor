package org.monitor.yarn.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.monitor.yarn.conf.PropertyFetcher;
import org.monitor.yarn.constant.Constants;
import org.monitor.yarn.constant.ResourceStyle;
import org.monitor.yarn.dao.QueueMemUsedCountDao;
import org.monitor.yarn.dao.impl.common.FetchJmx2SQL;
import org.monitor.yarn.domain.Data;
import org.monitor.yarn.domain.QueueUsedCount;
import org.monitor.yarn.jdbc.JDBCHelper;
import org.monitor.yarn.util.DateUtils;
import org.monitor.yarn.util.NodeParseUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * Created by Administrator on 2017/6/16.
 */
public class QueueMemUsedCountImpl  implements QueueMemUsedCountDao {

    @Override
    public void insert(Date date) {

        Object toJSON = FetchJmx2SQL.Jmx2SQL(date, ResourceStyle.MEMORY);

        String viewTime = DateUtils.formatTime(date);
        String viewDate = DateUtils.formatDate(date);

            String sql = "insert into QueueMemUsedCountJson values(?,?,?,?)";
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
