package org.example.fly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @ClassName TaskConfig
 * @Author moon
 * @Date 2021/5/7
 * @Version V1.0
 **/
@Configuration
@ComponentScan
public class TaskConfig {

    @Bean
    public ThreadPoolTaskExecutor getTask(){
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        // 核心线程数量
        poolTaskExecutor.setCorePoolSize(5);
        // 最大线程数量
        poolTaskExecutor.setMaxPoolSize(20);
        // 最大队列容量
        poolTaskExecutor.setQueueCapacity(25);
        return poolTaskExecutor;
    }


}
