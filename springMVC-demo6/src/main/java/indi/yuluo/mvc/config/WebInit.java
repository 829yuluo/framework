package indi.yuluo.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author: yuluo
 * @FileName: WebInit.java
 * @createTime: 2022/4/7 12:44
 * @Description: web工程的初始化类，用来替代web.xml
 */

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 获取跟配置  -- spring的配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 放置配置类
        return new Class[] {SpringConfig.class};
    }

    /**
     * 指定spring MVC的配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    /**
     * 获取DispatcherServlet的映射规则（url-pattern）
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    /**
     * 注册过滤器
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceRequestEncoding(true);

        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[] {characterEncodingFilter, hiddenHttpMethodFilter};
    }
}
