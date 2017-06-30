package org.monitor.yarn.test;

import java.util.Map;
import java.util.TreeMap;


/**
 * Created by Administrator on 2017/6/20.
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String,String> map =  new TreeMap<String, String>();
        map.put("1","map1");
        map.put("1","map2");
        System.out.println(map);

    }
}
