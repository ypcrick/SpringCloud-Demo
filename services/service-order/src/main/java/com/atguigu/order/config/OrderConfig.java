package com.atguigu.order.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfig {

    /**
     * 设置Feign的重试机制
     * @return
     */
    @Bean
    Retryer retryer(){
        return new Retryer.Default();
    }

    /**
     * 设置Feign日志级别
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 负载均衡器
     * @return
     */
    @LoadBalanced//注解式负载均衡器，SpringCloud提供，默认是轮询
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
