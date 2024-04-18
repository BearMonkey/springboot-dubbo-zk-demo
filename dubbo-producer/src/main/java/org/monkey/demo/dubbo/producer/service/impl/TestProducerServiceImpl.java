package org.monkey.demo.dubbo.producer.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.monkey.demo.dubbo.api.HelloApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@DubboService
@Service
public class TestProducerServiceImpl implements HelloApi {

    private static final Logger logger = LoggerFactory.getLogger(TestProducerServiceImpl.class);

    @Override
    public String sayHello() {

        System.out.println(33);
        return "hello I'm dubbo producer";
    }
}
