package indi.exer.yuluo;

import indi.exer.yuluo.Bean.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

/**
 * @author: yuluo
 * @createTime: 2021/12/9 12:27
 * @Description:
 */

@Configuration
// 运用注解的排除策略
/**
 * <context:component-scan base-package="indi.exer.yuluo" use-default-filters="false">
 *         <context:include-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
 * </context:component-scan>
 */
/*@ComponentScan(basePackages = "indi.exer.yuluo.scan",
               excludeFilters = {
                                // 排除Service注解  也可以叠加使用
                                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Service.class})})
                                // 基于类的排除注解
                                *//*@ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "*..User1")})*/
@ComponentScan(basePackages = "indi.exer.yuluo.scan")
// 运用import创建对象
@Import(User.class)
public class AppConfig2 {
}
