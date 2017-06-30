package org.monitor.yarn.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public class QueueUsedCount {
    private  String name;
    private List<Data> data = new ArrayList<Data>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public void addData(Data data) {
        this.data.add(data);
    }
}