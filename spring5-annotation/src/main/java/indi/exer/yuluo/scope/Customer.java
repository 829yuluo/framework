package indi.exer.yuluo.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author: yuluo
 * @createTime: 2021/12/3 16:54
 * @Description: Scope注解，对象创建次数 singleton创建一次 prototype 创建多次
 *               如果不添加@Scope注解，会自动默认@Scope("singleton")
 */

@Component
@Scope("prototype")
public class Customer {
}
