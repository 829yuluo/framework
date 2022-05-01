package indi.exer.yuluo.mybatis;

import indi.exer.yuluo.mybatis.Dao.UserDAO;
import indi.exer.yuluo.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: yuluo
 * @createTime: 2021/11/27 11:59
 * @Description:
 *
 * mybatis: 开发步骤
 *  1. 实体类的创建
 *  2. 实体别名的配置
 *  3. 表
 *  4. 创建DAO接口
 *  5. 实现Mapper文件
 *  6. 注册Mapper文件
 *  7. MybatisAPI的调用
 *
 * Mybatis开发过程中存在的问题
 *
 *      配置繁琐    代码冗余
 *
 *  1. 实体类的创建
 *  2. 实体别名的配置     配置繁琐
 *  3. 表
 *  4. 创建DAO接口
 *  5. 实现Mapper文件
 *  6. 注册Mapper文件    配置繁琐
 *  7. MybatisAPI的调用    代码冗余
 *
 */

public class TestMybatis {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        UserDAO userDAO = session.getMapper(UserDAO.class);

        User user = new User();
        user.setName("yuluo");
        user.setPassword("w082196x");

        userDAO.save(user);

        session.commit();

    }

}
