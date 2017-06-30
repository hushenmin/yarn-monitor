package org.monitor.yarn.test;

import org.monitor.yarn.util.NodeParseUtils;
import org.omg.CORBA.Object;

/**
 * Created by Administrator on 2017/6/15.
 */
public class TestNodeParseutils {
    public static void main(String[] args) {
        NodeParseUtils nodeParseUtils = new NodeParseUtils("root");
        System.out.println(nodeParseUtils.isRoot());
        System.out.println(nodeParseUtils.isParent("root.bigdata.friend"));

        System.out.println(nodeParseUtils.isParent("root.bigdata.friend"));

    }
}
