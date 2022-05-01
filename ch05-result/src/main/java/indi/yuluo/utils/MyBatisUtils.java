package indi.yuluo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: yuluo
 * @createTime: 2022/1/22 19:24
 * @File : MyBatisUtils.java
 * @Software : IntelliJ IDEA
 * @Description: MyBatis的工具类
 */

public class MyBatisUtils {

    private static SqlSessionFactory factory = null;

    static {
        try {
            // 读取主配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
            // 创建SqlSessionFactory对象
            factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 创建获取session的方法
    public static SqlSession getSqlSession() {
        SqlSession session = null;
        if (factory != null) {
            session = factory.openSession();
        }
        return session;
    }

}
