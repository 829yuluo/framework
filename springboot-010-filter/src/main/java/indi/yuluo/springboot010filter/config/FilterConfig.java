package indi.yuluo.springboot010filter.config;

import indi.yuluo.springboot010filter.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author: yuluo
 * @FileName: FilterConfig.java
 * @createTime: 2022/5/13 21:56
 * @Description:
 */

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean myFilterRegistrationBean() {

        // 注册过滤器
        FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>(new MyFilter());
        // 添加过滤路径
        myFilterFilterRegistrationBean.addUrlPatterns("/user/**");

        return myFilterFilterRegistrationBean;
    }

}
