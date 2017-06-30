package org.monitor.yarn.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public class DataSets {
    private  String name ;
    private ArrayList<Long> maxValue;
    private FairUsed usedValues;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Long> getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(ArrayList<Long> maxValue) {
        this.maxValue = maxValue;
    }

    public FairUsed getUsedValues() {
        return usedValues;
    }

    public void setUsedValues(FairUsed usedValues) {
        this.usedValues = usedValues;
    }
}


