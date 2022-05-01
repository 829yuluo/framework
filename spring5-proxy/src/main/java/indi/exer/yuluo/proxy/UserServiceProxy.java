package indi.exer.yuluo.proxy;

/**
 * @author: yuluo
 * @createTime: 2021/11/18 19:34
 * @Description:
 *
 * proxy 代理类 ： 代理类 = 目标类(原始类) + 额外功能 + 原始类(目标类)实现相同的接口
 *
 */


// 实现相同的接口 implements UserService
public class UserServiceProxy implements UserService {

    // 原始对象
    private UserServiceImpl userService = new UserServiceImpl();

    // 重写一样的方法 实现原始的接口
    @Override
    public void register(User user) {
        // 额外功能的添加
        System.out.println("-------log-------");
        System.out.println(user);
    }

    @Override
    public boolean login(String name, String password) {

        System.out.println("-----log------");

        return userService.login(name, password);
    }
}
