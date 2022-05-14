package indi.yuluo.springboot007dubboconsumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // 开启spring的注解配置
@EnableDubboConfiguration // 开启dubbo注解配置
public class Springboot007DubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot007DubboConsumerApplication.class, args);
    }

}
