package org.monitor.yarn.test;

import org.monitor.yarn.dao.impl.FetchSQLFairSharedFilter2JsonImpl;

/**
 * Created by Administrator on 2017/6/28.
 */
public class TestFairsharedJson {
    public static void main(String[] args) {
        new FetchSQLFairSharedFilter2JsonImpl().callAllCpuMessage(2);
    }
}
