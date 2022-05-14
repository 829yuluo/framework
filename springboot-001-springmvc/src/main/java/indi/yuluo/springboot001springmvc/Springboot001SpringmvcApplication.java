package indi.yuluo.springboot001springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// springboot项目的启动类
@SpringBootApplication  // 开启springboot的配置
public class Springboot001SpringmvcApplication {

    // 注意：springboot的项目代码必须放在application类所在的同级目录或者下级目录

    public static void main(String[] args) {
        SpringApplication.run(Springboot001SpringmvcApplication.class, args);
    }

}
