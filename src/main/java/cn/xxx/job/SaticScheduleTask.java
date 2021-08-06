package cn.xxx.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

//@Component
//@Async
public class SaticScheduleTask {
    //3.添加定时任务
    @Scheduled(cron="*/1 * * * * ?")
    public void configureTasks() {
         System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        try {
            sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}