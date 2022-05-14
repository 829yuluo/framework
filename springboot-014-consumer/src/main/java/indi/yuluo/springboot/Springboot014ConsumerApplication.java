package indi.yuluo.springboot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class Springboot014ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot014ConsumerApplication.class, args);
    }

}
