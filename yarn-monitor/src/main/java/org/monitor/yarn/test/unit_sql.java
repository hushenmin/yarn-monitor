package org.monitor.yarn.test;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/27.
 */
public class unit_sql {
    private  String name;
    private String timeStamp;
    private Cpu Cpu;
    private Mem Mem;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public org.monitor.yarn.test.Cpu getCpu() {
        return Cpu;
    }

    public void setCpu(org.monitor.yarn.test.Cpu cpu) {
        Cpu = cpu;
    }

    public org.monitor.yarn.test.Mem getMem() {
        return Mem;
    }

    public void setMem(org.monitor.yarn.test.Mem mem) {
        Mem = mem;
    }
}
