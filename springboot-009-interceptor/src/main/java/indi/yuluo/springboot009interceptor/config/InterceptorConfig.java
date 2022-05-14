package indi.yuluo.springboot009interceptor.config;

import indi.yuluo.springboot009interceptor.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: yuluo
 * @FileName: InterceptorConfig.java
 * @createTime: 2022/5/13 21:12
 * @Description: 定义此类为配置类
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * mvc:interceptors
     * @param registry 拦截器注册类
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 要拦截user下的所有请求，必须用户登录后才可以访问
        // 但是这样拦截的路径中有一些是不需要用户登录也可以访问的
        // **表示/user下的后代目录
        String[] addPathPatterns = {
                "/user/**"
        };

        // 要放行的
        String[] excludePathPatterns = {
                "/user/out", "/user/error", "/user/login"
        };

        // mvc:interceptors
        registry.addInterceptor(new UserInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
