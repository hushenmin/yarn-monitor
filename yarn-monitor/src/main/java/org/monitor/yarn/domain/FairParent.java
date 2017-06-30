package org.monitor.yarn.domain;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public class FairParent {
    private List xData;
    private List<DataSets> datasets;

    public List getxData() {
        return xData;
    }

    public void setxData(List xData) {
        this.xData = xData;
    }

    public List<DataSets> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<DataSets> datasets) {
        this.datasets = datasets;
    }
}
