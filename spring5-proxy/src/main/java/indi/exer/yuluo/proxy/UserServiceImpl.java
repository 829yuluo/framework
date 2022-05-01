package indi.exer.yuluo.proxy;

/**
 * @author: yuluo
 * @createTime: 2021/11/18 19:31
 * @Description:
 *
 *          原始类
 *          提供代理类 ： UserServiceProxy
 *          **静态代理**：为每一个原始类，手工编写一个代理类 (.java .class)
 *
 */

public class UserServiceImpl implements UserService{

    @Log
    @Override
    public void register(User user) throws Exception {

        System.out.println("UserServiceImpl.register 业务运算 + DAO");
//         throw new Exception("这是一个测试异常");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return false;
    }
}
