package org.monitor.yarn.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/6/20.
 */
public class TestMapJson {
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<String,String>();
        for (int i = 0 ; i >=10;i++){
            map.put(i +" ","value"+i);
        }
    }
}
