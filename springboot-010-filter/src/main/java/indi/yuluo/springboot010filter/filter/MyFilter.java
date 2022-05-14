package indi.yuluo.springboot010filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author: yuluo
 * @FileName: MyFilter.java
 * @createTime: 2022/5/13 21:51
 * @Description:
 */

@WebFilter(urlPatterns = "/myfilter")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--------进入过滤器---------");

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
