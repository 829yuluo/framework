package indi.yuluo.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: yuluo
 * @FileName: TestInterceptor.java
 * @createTime: 2022/4/7 16:05
 * @Description:
 */

public class TestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("TestInterceptor.preHandle");
        return true;
    }
}
