package com.demo.compatablefuture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync //Allow asynchronous code in the application using tread pool concept
public class AsyncConfig {

     @Bean(name = "taskExecutor")
     public Executor taskExecutor() {
          ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
          executor.setCorePoolSize(2); //Number of threads that can be alive without time out//
          executor.setCorePoolSize(2); //Number of thread that can be created depending on queue capacity
          executor.setQueueCapacity(100); //Capacity of adding thread in the queue
          executor.setThreadNamePrefix("userThread-");
          executor.initialize();
          return executor;

     }
}
