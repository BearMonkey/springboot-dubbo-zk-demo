package org.monkey.demo.dubbo.producer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "org.monkey.demo.dubbo.producer.service.impl")
public class DubboProducerApp {
    public static void main(String[] args) {
        SpringApplication.run(DubboProducerApp.class, args);
    }
}
