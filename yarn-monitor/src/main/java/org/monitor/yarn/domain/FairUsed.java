package org.monitor.yarn.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public class FairUsed {
    private  String queue ;
    private ArrayList<Long> usedData;

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public ArrayList<Long> getUsedData() {
        return usedData;
    }

    public void setUsedData(ArrayList<Long> usedData) {
        this.usedData = usedData;
    }

}
