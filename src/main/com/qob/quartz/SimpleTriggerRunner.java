package com.qob.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerRunner {
    public static void main(String args[]){
        try{
            JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job1_1", "jgroup1").build();
            SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(5)		//设置间隔执行时间
                    .repeatSecondlyForTotalCount(5);//设置执行次数

            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1_1","tGroup1").startNow().withSchedule(builder).build();

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
