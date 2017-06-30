package org.monitor.yarn.controller.yarnmonitor;

import com.alibaba.fastjson.JSON;
import org.monitor.yarn.conf.PropertyFetcher;
import org.monitor.yarn.constant.Constants;
import org.monitor.yarn.dao.factory.DaoFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */
@RestController
@RequestMapping("/yarn-monitor")
public class YarnMonitorController extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(YarnMonitorController.class);
    }
    @RequestMapping(value = "/mem-all-message", method = RequestMethod.GET)
    public JSON callMessageMemory() {
        DaoFactory daoFactory = new DaoFactory();
        int limit = PropertyFetcher.getInt(Constants.CHART_BATCH_LIMIT_DAYS_AGO);
        return daoFactory.getMemUsedJsonDao().callMessage(limit);
    }
    @RequestMapping(value = "/mem-one-message", method = RequestMethod.GET)
    public  Object callOneMessageMem(){
        DaoFactory daoFactory = new DaoFactory();
        return  daoFactory.getMemUsedJsonDao().callOneMessage();
    }
    @RequestMapping(value = "/cpu-all-message", method = RequestMethod.GET)
    public JSON callMessageCpu() {
        DaoFactory daoFactory = new DaoFactory();
        int limit = PropertyFetcher.getInt(Constants.CHART_BATCH_LIMIT_DAYS_AGO);
        return daoFactory.getCpuUsedJsonDao().callMessage(limit);
    }
    @RequestMapping(value = "/cpu-one-message", method = RequestMethod.GET)
    public  Object callOneMessageCpu(){
        DaoFactory daoFactory = new DaoFactory();
        return  daoFactory.getCpuUsedJsonDao().callOneMessage();
    }
    @RequestMapping(value = "/fairmemused-message", method = RequestMethod.GET)
    public Object callAllMemMessage(){
        DaoFactory daoFactory = new DaoFactory();
        int limit = PropertyFetcher.getInt(Constants.CHART_BATCH_LIMIT_DAYS_AGO);
        return  daoFactory.getFetchSQLFairSharedFilter2JsonDao().callAllMemMessage(limit);
    }

    @RequestMapping(value = "/faircpuused-message", method = RequestMethod.GET)
    public Object callAllCpuMessage(){
        DaoFactory daoFactory = new DaoFactory();
        int limit = PropertyFetcher.getInt(Constants.CHART_BATCH_LIMIT_DAYS_AGO);
        return  daoFactory.getFetchSQLFairSharedFilter2JsonDao().callAllCpuMessage(limit);
    }



    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
         configurableEmbeddedServletContainer.setPort(8081);

    }
}

