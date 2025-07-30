package com.sky.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @BelongsProject: sky-take-out
 * @BelongsPackage: com.sky.task
 * @Author: tan
 * @CreateTime: 2025-07-28  22:35
 * @Description: 自定义定时任务类
 */
@Component
@Slf4j
public class MyTask {

    /**
     * description: 定时任务，每隔5秒触发一次
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/28 22:39
     * @return: void
     */
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void executeTask(){
//        log.info("定时任务开始执行 : {}",new Date());
//    }
}
