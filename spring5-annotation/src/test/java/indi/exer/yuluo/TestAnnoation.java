package indi.exer.yuluo;

import indi.exer.yuluo.bean.User;
import indi.exer.yuluo.injection.Category;
import indi.exer.yuluo.injection.UserService;
import indi.exer.yuluo.lazy.Account;
import indi.exer.yuluo.scope.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: yuluo
 * @createTime: 2021/12/3 16:30
 * @Description:
 */

public class TestAnnoation {

    /**
     * 用于测试：@Component注解
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        /* id 的默认值是 首单词首字母小写*/
        User user = (User) ctx.getBean("u");
        System.out.println("user = " + user);
    }

    /**
     * 用于测试：@Scope注解
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        /* id 的默认值是 首单词首字母小写*/
        Customer customer = (Customer) ctx.getBean("customer");

        Customer customer1 = (Customer) ctx.getBean("customer");

        System.out.println("customer = " + customer);
        System.out.println("customer1 = " + customer1);
    }

    /**
     * 用于测试：@Lazy注解
     * 当spring工厂建立的时候就会创建单实例对象
     * 加上@Lazy注解就会延迟创建单实例对象
     * 当用ctx.getBean时创建对象
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Account account = (Account) ctx.getBean("account");
        System.out.println("account = " + account);
    }

    /**
     * 用于测试：对象的生命周期
     */
    @Test
    public void test4() {
        /**
         * 创建对象便会调用初始化方法
         * 关闭会调用销毁方法
         */
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        ctx.close();
    }

    /**
     * 用于测试：@Autowired注解
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");

        userServiceImpl.register();
    }

    /**
     * 用于测试：@Value注解
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Category category = (Category) ctx.getBean("category");
        System.out.println("category = " + category.getId());
        System.out.println("category = " + category.getName());
    }

    /**
     * 用于测试：排除策略
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // ctx.getBeanDefinitionNames(); 获取对象的id值
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        // 遍历输出
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        /**
         * 不过滤注解输出的结果
         * beanDefinitionName = u
         * beanDefinitionName = category
         * beanDefinitionName = userDAOImpl
         * beanDefinitionName = userServiceImpl
         * beanDefinitionName = account
         * beanDefinitionName = product
         * beanDefinitionName = customer
         * beanDefinitionName = org.springframework.context.annotation.internalConfigurationAnnotationProcessor
         * beanDefinitionName = org.springframework.context.annotation.internalAutowiredAnnotationProcessor
         * beanDefinitionName = org.springframework.context.annotation.internalCommonAnnotationProcessor
         * beanDefinitionName = org.springframework.context.event.internalEventListenerProcessor
         * beanDefinitionName = org.springframework.context.event.internalEventListenerFactory
         *
         * 通过spring的配置文件进行过滤之后输出的结果
         *
         * beanDefinitionName = category
         * beanDefinitionName = userDAOImpl
         * beanDefinitionName = userServiceImpl
         * beanDefinitionName = account
         * beanDefinitionName = product
         * beanDefinitionName = customer
         * beanDefinitionName = org.springframework.context.annotation.internalConfigurationAnnotationProcessor
         * beanDefinitionName = org.springframework.context.annotation.internalAutowiredAnnotationProcessor
         * beanDefinitionName = org.springframework.context.annotation.internalCommonAnnotationProcessor
         * beanDefinitionName = org.springframework.context.event.internalEventListenerProcessor
         * beanDefinitionName = org.springframework.context.event.internalEventListenerFactory
         * beanDefinitionName = user
         */
    }

}
