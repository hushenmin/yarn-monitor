package org.monitor.yarn.test;

import org.monitor.yarn.dao.factory.DaoFactory;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/13.
 */
public class TestMonitorYarn {
    public static void main(String[] args) throws InterruptedException {
        DaoFactory daoFactory = new DaoFactory();
        while (true){
            daoFactory.getQueueCpuUsedCountDao().insert(new Date());
            daoFactory.getQueueMemUsedCountDao().insert(new Date());
            Thread.sleep(10000);
        }
    }
}
