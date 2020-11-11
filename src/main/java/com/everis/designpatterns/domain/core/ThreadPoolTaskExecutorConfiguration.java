package com.everis.designpatterns.domain.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@RequiredArgsConstructor
@Slf4j
public class ThreadPoolTaskExecutorConfiguration implements AsyncConfigurer {

    private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    private static final int MAX_POOL_SIZE = CORE_POOL_SIZE * 2;

    @Override
    public Executor getAsyncExecutor() {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setThreadNamePrefix("async-task");
        executor.setBeanName(ThreadPoolTaskExecutorConfiguration.class.getSimpleName());
        executor.setQueueCapacity(Integer.MAX_VALUE);
        executor.initialize();
        log.info("M=getAsyncExecutor,corePoolSize={}", CORE_POOL_SIZE);
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
