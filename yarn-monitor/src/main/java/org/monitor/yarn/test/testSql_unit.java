package org.monitor.yarn.test;

import com.alibaba.fastjson.JSON;
import org.monitor.yarn.util.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
public class testSql_unit {
    public static void main(String[] args) {
        Cpu cpu1 = new Cpu();
        Mem mem1 = new Mem();
        unit_sql  unit_sql1  = new unit_sql();
        cpu1.setFair("12");
        cpu1.setUsed("6");
        mem1.setFair("1024");
        mem1.setUsed("512");
        unit_sql1.setName("root");
        unit_sql1.setCpu(cpu1);
        unit_sql1.setMem(mem1);
        unit_sql1.setTimeStamp(DateUtils.formatTimeStamp(new Date()));


        Cpu cpu2 = new Cpu();
        Mem mem2= new Mem();
        unit_sql  unit_sql2  = new unit_sql();
        cpu2.setFair("6");
        cpu2.setUsed("2");
        mem2.setFair("512");
        mem2.setUsed("216");
        unit_sql2.setName("root.bi");
        unit_sql2.setCpu(cpu1);
        unit_sql2.setMem(mem1);
        unit_sql2.setTimeStamp(DateUtils.formatTimeStamp(new Date()));
        List<unit_sql> list =  new ArrayList<unit_sql>();
        list.add(unit_sql1);
        list.add(unit_sql2);
        System.out.println(JSON.toJSON(list).toString());









    }

}
