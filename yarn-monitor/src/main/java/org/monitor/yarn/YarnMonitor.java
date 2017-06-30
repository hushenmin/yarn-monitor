package org.monitor.yarn;

import org.monitor.yarn.conf.PropertyFetcher;
import org.monitor.yarn.constant.Constants;
import org.monitor.yarn.dao.factory.DaoFactory;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/22.
 */
public class YarnMonitor {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        DaoFactory daoFactory = new DaoFactory();
        while (true){
            Date date = new Date();
            daoFactory.getQueueCpuUsedCountDao().insert(date);
            daoFactory.getQueueMemUsedCountDao().insert(date);
            daoFactory.getFairSharedCountDao().insert(date);
            Thread.sleep(PropertyFetcher.getInt(Constants.TIME_INTERVAL) * 1000);
        }
    }
}
