package indi.exer.yuluo.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author: yuluo
 * @createTime: 2021/11/13 20:14
 * @Description: 验证spring创建对象的的创建阶段
 */

public class Product implements InitializingBean, DisposableBean {

//    private String name;
//
//    public String getName() {
//        System.out.println("Product.getName");
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Product() {
        System.out.println("对象的创建阶段： Product.Product");
    }

    public void myInit() {
        System.out.println("initializing……");
    }


     // 初d始化方法：做一些初始化操作
     // 会被spring调用
     // @throws Exception
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("对象初始化 Product.afterPropertiesSet");
    }

    //销毁方法：销毁操作（资源释放的操作）
    @Override
    public void destroy() throws Exception {
        System.out.println("对象的销毁 Product.destroy");
    }

    public void myDestory() throws Exception {
        System.out.println("自己的销毁对象方法");
    }

}
