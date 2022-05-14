package indi.yuluo.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("indi.yuluo.springboot.dao") // 扫描mybatis-plus的mapper文件
public class Springboot003MybatisApplication {

    public static void main(String[] args) {

        SpringApplication.run(Springboot003MybatisApplication.class, args);
    }

}
