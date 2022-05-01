package indi.exer.yuluo;

import indi.exer.yuluo.basic.BeanFactory;
import indi.exer.yuluo.basic.Person;
import indi.exer.yuluo.basic.User;
import indi.exer.yuluo.basic.UserService;
import indi.exer.yuluo.beanpost.Categroy;
import indi.exer.yuluo.constructer.Customer;
import indi.exer.yuluo.converter.People;
import indi.exer.yuluo.factorybean.ConnectionFactoryBean;
import indi.exer.yuluo.life.Product;
import indi.exer.yuluo.scope.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.Properties;

public class TestSpring<test2> {

    @Test
    public void test1() {

        //new UserServiceImpl耦合程度太高
        //private UserDAO userDAO = new UserDAOImpl();

        UserService userService = (UserService) BeanFactory.getBean("userService");

        userService.login("name", "suns");

        User user = new User("suns", "123456");
        userService.register(user);


    }

    @Test
    /**
     * Person.Person
     * person = indi.exer.yuluo.basic.Person@ea30797
     * 输出结果包含Person.person说明调用了person类的构造方法
     *
     * spring的工厂会调用私有的构造方法和变量
     *
     */
    public void test2() {
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println("person = " + person );
    }

    /**
     * 用来测试spring的第一个项目
     */
    @Test
    public void test3() {
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println("person =" + person);

        //1 获得spring的工厂 使用spring的工厂配置

        /**
         * spring创建的对象叫做bean或者组件
         */

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //通过工厂类 获得对象
        Person person1 = (Person) ctx.getBean("person");
        System.out.println("person1 = " + person1);
    }

    /**
     * 用于测试：
     */
    @Test
    public void test4() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //通过这种方式获得对象，就不需要强制类型转换
        /*Person person = ctx.getBean("person", Person.class);
        System.out.println("person = " + person);*/

        //必须保证当前的spring配置文件中只有< bean class >是person类型
        /*Person bean = (Person) ctx.getBean(Person.class);
        System.out.println("bean = " + bean);*/

        //获取的是Spring工厂配置中的所有bean标签的id值  person person1
        /*String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }*/

        //根据类型获得Spring配置文件中对应的id值
        /*String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
        for (String id : beanNamesForType) {
            System.out.println("id = " + id);
        }*/
        
        //用于判断是否存在指定id值的bean 只能判断id 不能判断别名（name）
        /*if (ctx.containsBeanDefinition("person2")) {
            System.out.println("true= " + true);  
        } else {
            System.out.println("false = " + false);
        }*/

        //用于判断是否存在指定id值的bean 可以判断 id和别名（name）
        if (ctx.containsBean("person")) {
            System.out.println("true = " + true);
        } else {
            System.out.println("false = " + false);
        }

    }

    /**
     * 用于测试：spring的配置文件
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

    /**
     * 用于测试name的属性名
     */
    @Test
    public void test6() {
        /**
         * Class clazz = Class.forName(env.getProperty(key));
         * ret = clazz.newInstance();
         *
         * 反射创建类的方法会不会调用类中的构造方法呢？
         *       会的
         *
         *
         * 对spring创建对象的思考：
         *      在未来的开发过程中，并不是所有的类都会交给spring工厂来创建
         *      特例：
         *          实体对象（entity）是不会交给spring创建，它是由持久层框架来创建的
         *          它的数据都来自与数据库
         *
         */
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = (Person) ctx.getBean("/person");
        System.out.println("----------------------------");
        System.out.println("p = " + p);
    }

    /**
     * 用于测试：用于测试注入
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ctx.getBean("person");

        /**
         * 基本赋值
         * 通过代码为成员变量赋值，存在耦合关系
         * 因此就需要用到注入技术
         */
        person.setId(1);
        person.setName("yuluo");

        System.out.println("person = " + person);
    }

    /**
     * 用于测试： 通过spring的配置文件进行赋值（注入）
     *
     * 注入的好处：
     *          解耦合
     *
     * 注入的原理：
     *          通过底层调用对象属性调用对应的set方法给成员变量复制
     *
     */
    @Test
    public void test8() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println("person = " + person);
    }

    /**
     * 用于测试：jdk内置类型的set注入
     * 数组
     */
    @Test
    public void text9() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ctx.getBean("person");

        /*String[] emails = person.getEmails();
        for (String email : emails) {
            System.out.println("email = " + email);
        }

        System.out.println("--------------------");

        *//**
         * set集合的特点：无序性和不可重复性
         *//*
        Set<String> tels = person.getTels();
        for (String tel : tels) {
            System.out.println("tel = " + tel);
        }
*/
        /**
         * list集合的特点：元素有序性和可重复性
         * */
        /*List<String> list = person.getAddress();
        for (String s : list) {
            System.out.println("s = " + s);
        }*/

        /**
         * map集合的遍历特点
         * 有三种方法：
         *      键遍历
         *      值遍历
         *      键值遍历
         */
        // 键遍历方法
        /*Map<String, String> qqs = person.getQqs();
        Set<String> keys = qqs.keySet();
        for (String key : keys) {
            System.out.println("key = " + key + "   value is " + qqs.get(key));
        }*/

        /**
         * 打印properties
         *
         */
        Properties p = person.getP();
        System.out.println("key is" + "key1" + p.getProperty("key1"));
        System.out.println("key is" + "key2" + p.getProperty("key2"));

    }

    /**
     * 用于测试自己定义的成员变量赋值
     *
     */
    @Test
    public void test10() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");

        UserService userService = (UserService) ctx.getBean("UserService");

        userService.register(new User("yuluo", "123456"));
        userService.login("huakai", "123456");

    }

    /**
     * 用于测试构造方法给私有的成员变量赋值
     */
    @Test
    public void test11() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer);
    }

    /**
     * 用于测试： FactoryBean接口,创建的是Connection的复杂对象
     *
     * FactoryBean：spring中原生的一种用于创建负责对象的方法
     *
     */
    @Test
    public void test12() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //在创建复杂对象的时候，如果isSingleton()方法返回false，每次创建的都是不同的对象
        /*bean = com.mysql.cj.jdbc.ConnectionImpl@47d9a273
         connection = com.mysql.cj.jdbc.ConnectionImpl@4b8ee4de*/
        //如果返回true，创建的都是相同的对象
        /*bean = com.mysql.cj.jdbc.ConnectionImpl@26e356f0
        connection = com.mysql.cj.jdbc.ConnectionImpl@26e356f0*/

        /**
         * 在选择时，如果对象能被共用，就true，
         * 不能就是false
         */

        Connection connection = (Connection) ctx.getBean("connection");
        Connection bean = (Connection) ctx.getBean("connection");

        System.out.println("bean = " + bean);
        System.out.println("connection = " + connection);

    }

    /**
     * 用于测试： FactoryBean接口,创建ConnectionFactoryBean对象
     */
    @Test
    public void test13() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        ConnectionFactoryBean connection = (ConnectionFactoryBean) ctx.getBean("&connection");



        System.out.println("connection = " + connection);
    }

    /**
     * 用于测试：实例工厂创建复杂对象：
     *      避免spring框架的侵入，因为FactoryBe是spring工厂原生的方法，
     *      整合之前遗留的系统
     */
    @Test
    public void test14() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection bean = (Connection) ctx.getBean("connection");

        System.out.println("bean = " + bean);
    }

    /**
     * 用于测试：静态工厂创建复杂对象
     */
    @Test
    public void test15() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection staticConnection = (Connection) ctx.getBean("staticConnection");

        System.out.println("staticConnection = " + staticConnection);
    }

    /**
     * 用于测试：简单对象的创建次数
     *
     * 创建对象的次数控制原因：
     *      节省不必要的内存空间
     *      创建一次的对象：
     *          SqlSessionFactory
     *          DAO
     *          Service
     *      每次都要创建的对象：
     *          Connection
     *          SqlSession | Session
     *          Struts1 Action
     *
     */
    @Test
    public void test16() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Account account1 = (Account) ctx.getBean("account");
        Account account2 = (Account) ctx.getBean("account");

        System.out.println("accoutn = " + account1);
        System.out.println("accoutn = " + account2);

        /*
          account = indi.exer.yuluo.scope.Account@4659191b
          account = indi.exer.yuluo.scope.Account@4659191b

          account = indi.exer.yuluo.scope.Account@4659191b
          account = indi.exer.yuluo.scope.Account@55634720
        */
    }

    /**
     * 用于测试：
     *
     * 什么是对象的生命周期：
     *      指的是一个对象，创建，存活，消亡，的一个过程
     *
     *      在spring中，由spring控制对象的生命周期，
     *
     * 生命周期的3个阶段：
     *
     *      创建阶段
     *          scope为多次的时候，他在创建对象的时候才调用
     *          scope为一次的时候，他在spring工厂创建时即创建对象
     *
     *      初始化阶段
     *          初始化方法：做一些初始化操作
     *          会被spring调用
     *          程序员根据需求 实现的方法 完成初始化操作
     *              1，InitializingBean接口
     *                  afterPropertiesSet()
     *              2，自己提供一个初始化的普通方法，通过配置文件配置
     *                  <bean id="product" class="XXX" init-method="myInit"/>
     *          同时存在时，先执行InitializeBean后执行程序员自定义的方法
     *          set注入在创建对象之前
     *          初始化操作一般是：
     *              数据库，IO，network ……
     *
     *      销毁阶段
     *          spring销毁对象前，会调用对象的销毁方法，完成销毁操作
     *          在类中实现destroy()方法
     *          只是用于scope="singleton"即创建一次的对象
     *              ctx.clos()
     *          销毁方法：
     *              程序员根据自己的需求来定义销毁方法，由spring工厂来调用销毁方法
     *              通过配置文件告诉spring工厂
     *
     *          2021-11-14 13:51:57 DEBUG ClassPathXmlApplicationContext:1049 - Closing org.springframework.context.support.ClassPathXmlApplicationContext@4cdbe50f, started on Sun Nov 14 13:51:57 CST 2021
     *          对象的销毁 Product.destroy
     *
     */
    @Test
    public void test17() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Product product = (Product) ctx.getBean("product");
        //关闭spring的工厂
        ctx.close();
    }

    /**
     * 用于测试:配置文件参数化
     */
    @Test
    public void test18() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext1.xml");
        Connection conntecion = (Connection) ctx.getBean("connection");

        System.out.println("conntecion = " + conntecion);

    }

    /**
     * 用于测试:自定义类型转换器
     *
     * 在spring中没有提供日期类型的转换器，所以自定义类型转换器
     *
     */
    @Test
    public void test19() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        People people = (People) ctx.getBean("person");
        System.out.println("people = " + people);
        System.out.println("people.getBirthday() = " + people.getBirthday());
    }

    /**
     *
     * BeanPostProcess 的开发步骤
     * 需要一个类实现BeanPostprocess接口
     * spring中的配置文件进行配置
     *
     * 用于测试：BeanPostProcessor
     */
    @Test
    public void test20() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext3.xml");

        Categroy c = (Categroy) ctx.getBean("c");

        // System.out.println("c = " + c);
        System.out.println("name = " + c.getName());
    }
}
