package indi.yuluo.springboot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan("indi.yuluo.springboot.dao")
public class Springboot013ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot013ProviderApplication.class, args);
    }

}
