package org.monkey.demo.dubbo.consumer.controller;

import org.monkey.demo.dubbo.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/say")
    public String say() {
        System.out.println(11);
        return consumerService.sayHello();
    }
}
