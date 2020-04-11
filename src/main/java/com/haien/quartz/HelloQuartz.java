package com.haien.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @Author haien
 * @Description 具体任务逻辑
 * @Date 2019/5/10
 * @Param
 * @return
 **/
public class HelloQuartz implements Job {
    public void execute(JobExecutionContext jobExecutionContext)
            throws JobExecutionException {
        JobDetail detail=jobExecutionContext.getJobDetail();
        String name=detail.getJobDataMap().getString("name");
        System.out.println("my job name is "+name+" at "+new Date());
    }
}











































