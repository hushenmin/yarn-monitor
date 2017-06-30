package org.monitor.yarn.test;

import org.monitor.yarn.conf.PropertyFetcher;
import org.monitor.yarn.constant.Constants;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Administrator on 2017/6/22.
 */
public class TestUrl {
    public static void main(String[] args) {
       String str= PropertyFetcher.getProperty(Constants.JDBC_DRIVER);
        System.out.println(str);
    }
}
