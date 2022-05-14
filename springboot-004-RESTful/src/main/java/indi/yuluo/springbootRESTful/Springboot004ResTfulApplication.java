package indi.yuluo.springbootRESTful;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("indi.yuluo.springbootRESTful.dao")
public class Springboot004ResTfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot004ResTfulApplication.class, args);
    }

}
