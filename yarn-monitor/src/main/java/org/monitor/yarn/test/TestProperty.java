package org.monitor.yarn.test;

import org.monitor.yarn.conf.PropertyFetcher;
import org.monitor.yarn.constant.Constants;

/**
 * Created by Administrator on 2017/6/22.
 */
public class TestProperty {
    public static void main(String[] args) {

        String str = PropertyFetcher.getProperty(Constants.JDBC_DRIVER);
        System.out.println(str);
    }
}
