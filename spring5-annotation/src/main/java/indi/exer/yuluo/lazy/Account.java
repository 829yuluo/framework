package indi.exer.yuluo.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author: yuluo
 * @createTime: 2021/12/3 17:02
 * @Description: 使用@Lazy注解的时候，spring在使用这个对象的时候才会进行对这个对象的创建
 */

@Component
@Lazy
public class Account {
    public Account() {
        System.out.println("Account.Account");
    }
}
