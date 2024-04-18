这是一个说明文档！！！！
从0到1搭建一个dubbo zk spring-boot的整合项目，
#### 1.dubbo-api定义一个接口
```java
public interface HelloApi {
    String sayHello();
}
```
#### 2.生产者实现这个接口
```java
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
```
#### 3.生产者启动类同springboot
`@EnableDubbo`:定义dubbo服务包扫描路径
```java
@SpringBootApplication
@EnableDubbo(scanBasePackages = "org.monkey.demo.dubbo.producer.service.impl")
public class DubboProducerApp {
    public static void main(String[] args) {
        SpringApplication.run(DubboProducerApp.class, args);
    }
}
```

#### 4.生产者配置文件
```yaml
server:
  port: 8080

spring:
  application:
    name: dubbo-producer
dubbo:
  application:
    name: ${spring.application.name}
  registry:
    address: zookeeper://192.168.1.221:2181
  protocol:
    port: -1
    name: dubbo
```

#### 5.消费者实现接口
```java
public interface ConsumerService extends HelloApi {
    String sayHello();
}
// 为了更契合MVC模式，多增加一层service接口的定义，方便controller调用的习惯
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
```
#### 6.controller对外暴露http接口
```java
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
```
#### 7.消费者的启动类
```java
@SpringBootApplication
public class DubboConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApp.class, args);
    }
}
```
#### 8.消费者的配置文件
```yaml
server:
  port: 8081

spring:
  application:
    name: dubbo-consumer
dubbo:
  application:
    name: ${spring.application.name}
    qos-port: 33333   # 这里的33333接口是因为启动时报了一个端口被占用的错误，不明觉厉，搞明白了原因再补充
  registry:
    address: zookeeper://192.168.1.221:2181
  protocol:
    port: -1
    name: dubbo
```

#### 9 启动消费者和生产者，启动成功后，访问这个url
http://localhost:8081/consumer/say