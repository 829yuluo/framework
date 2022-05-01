package indi.exer.yuluo.proxy;

public interface UserService {

    public void register(User user) throws Exception;

    public boolean login(String name, String password);

}
