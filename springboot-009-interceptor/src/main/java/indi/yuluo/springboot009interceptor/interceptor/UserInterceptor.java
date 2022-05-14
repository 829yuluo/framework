package indi.yuluo.springboot009interceptor.interceptor;

import indi.yuluo.springboot009interceptor.modle.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: yuluo
 * @FileName: UserInterceptor.java
 * @createTime: 2022/5/13 21:07
 * @Description:
 */

public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 编写业务拦截的规则
        // 从session中获取用户的信息
        User user = (User) request.getSession().getAttribute("user");

        // 判断用户是否登录过
        if (user == null) {
            // 未登录，则跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/user/login");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
