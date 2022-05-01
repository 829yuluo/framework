package indi.exer.yuluo;

import indi.exer.yuluo.aop.UserService;
import indi.exer.yuluo.aop.AppConfig;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: yuluo
 * @createTime: 2021/12/10 22:10
 * @Description:
 */

public class TesyAonnotation1 {

    /**
     * 用于测试：纯注解开发aop
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");

        userServiceImpl.register();
        userServiceImpl.login();
    }

}
