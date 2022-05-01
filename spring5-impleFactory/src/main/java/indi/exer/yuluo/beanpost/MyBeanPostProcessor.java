package indi.exer.yuluo.beanpost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: yuluo
 * @createTime: 2021/11/18 15:50
 * @Description:
 */

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    /**
     *在初始化之前对对象进行加工处理
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    /**
     * 在初始化之后对对象进行加工处理
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Categroy categroy = null;

        if (bean instanceof Categroy) {
            // 获得Category对象
            categroy = (Categroy) bean;
            // 加工 修改categroy中name的值
            categroy.setName("huakai");
        }
        // 作为返回值返回
        return bean;

        /**
         * 配置注入
         * <bean id="myBeanPostprocessor" class="……"/>
         */

    }

}
