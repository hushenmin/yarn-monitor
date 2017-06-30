package org.monitor.yarn.test;

import org.monitor.yarn.conf.PropertyFetcher;
import org.monitor.yarn.constant.Constants;
import org.monitor.yarn.util.DateUtils;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/30.
 */
public class testTime {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(PropertyFetcher.getInt(Constants.TIME_INTERVAL) * 1000);
        System.out.println(DateUtils.formatTime(new Date()));
        Thread.sleep(PropertyFetcher.getInt(Constants.TIME_INTERVAL) * 1000);
        System.out.println(DateUtils.formatTime(new Date()));
    }
}
