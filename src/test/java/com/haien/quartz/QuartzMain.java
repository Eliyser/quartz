package com.haien.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author haien
 * @Description head first quartz
 * @Date 2019/5/10
 **/
public class QuartzMain {
    public static void main(String[] args) {
        //定义一个JobDetail, 具体执行逻辑
        JobDetail jobDetail=JobBuilder.newJob(HelloQuartz.class)
                .withIdentity("job1","group1") //定义name和group
                .usingJobData("name","sdas") //job需要传递的内容
                .build();

        //定义一个Trigger，触发器
        Trigger trigger=TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .startNow() //加入scheduler之后立刻执行
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                                   .withIntervalInSeconds(1) //每1s执行一次
                                                   .repeatForever() //重复执行
                                                    )
                .build();

        try {
            //创建scheduler
            Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail,trigger);
            scheduler.start();

            //运行6s后关闭
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scheduler.shutdown();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}











































