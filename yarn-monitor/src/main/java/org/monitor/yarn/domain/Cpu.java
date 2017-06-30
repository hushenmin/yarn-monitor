package org.monitor.yarn.domain;

/**
 * Created by Administrator on 2017/6/27.
 */
public class Cpu {
    private String fair;
    private String used;

    public String getFair() {
        return fair;
    }

    public void setFair(String fair) {
        this.fair = fair;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }
}
