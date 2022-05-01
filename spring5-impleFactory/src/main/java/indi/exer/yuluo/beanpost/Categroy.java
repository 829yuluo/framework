package indi.exer.yuluo.beanpost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: yuluo
 * @createTime: 2021/11/18 15:38
 * @Description:
 *
 * BeanPostProcess 的开发步骤
 * 需要一个类实现BeanPostprocess接口
 * spring中的配置文件进行配置
 *
 */

public class Categroy {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
