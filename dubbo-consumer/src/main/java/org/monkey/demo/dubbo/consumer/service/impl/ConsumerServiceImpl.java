package org.monkey.demo.dubbo.consumer.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.monkey.demo.dubbo.api.HelloApi;
import org.monkey.demo.dubbo.consumer.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @DubboReference
    private HelloApi helloApi;
    @Override
    public String sayHello() {
        System.out.println(22);
        return helloApi.sayHello();
    }
}
