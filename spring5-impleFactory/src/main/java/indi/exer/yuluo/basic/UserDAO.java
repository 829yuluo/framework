package indi.exer.yuluo.basic;

public interface UserDAO {

    //DAO层是数据访问层，在实际的开发过程中，一个DAO层对应的是一张表
    //通常实现对数据的CRUD操作，最好实现的是原子操作，增删改查

    public void save(User user);

    public void queryUserByUserAndPassword(String name, String password);

}