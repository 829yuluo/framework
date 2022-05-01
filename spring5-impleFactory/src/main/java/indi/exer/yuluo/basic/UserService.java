package indi.exer.yuluo.basic;

public interface UserService {

    //service层，是服务层，对DAO层做封装，成为一个服务。

    //controller是控制层，接受页面发过来的请求，传给service层进行处理，在将返回的结果传送给页面

    public void register(User user);

    public void login(String name, String password);

}
