package org.monkey.demo.dubbo.consumer.service;

import org.monkey.demo.dubbo.api.HelloApi;

public interface ConsumerService extends HelloApi {
    String sayHello();
}
