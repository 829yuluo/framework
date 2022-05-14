package indi.yuluo.springboot008nowebjava;

import indi.yuluo.springboot008nowebjava.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot008NowebJavaApplication {

    /*在第二种方式中注入StudentService*/
    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {

        /*
        第一种方式

        springboot程序启动后返回值是 configurableApplicationContext，是一个容器
        相当于原来spring容器中起送容器ClasspathXmlApplicationContext
         */

        // 获取springboot容器
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Springboot008NowebJavaApplication.class, args);

        // 从spring容器中获取指定的bean对象
        StudentService studentServiceImpl = (StudentService) applicationContext.getBean("studentServiceImpl");

        // 调用业务方法
        String s = studentServiceImpl.sayHello();
        System.out.println(s);


        /*
        第二种方式

        要求启动入口类实现一个CommandLineRunner,重写里面的run方法
         */

        // Springboot启动程序中，会初始化容器
        // SpringApplication.run(Springboot008NowebJavaApplication.class, args);
    }

    /*
    // 复写CommandLineRunner类中的run方法
    @Override
    public void run(String... args) throws Exception {
        // 调用业务方法
        String string = studentService.sayHello();

        System.out.println(string);
    }
    */

}
