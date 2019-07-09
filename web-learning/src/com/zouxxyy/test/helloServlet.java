package com.zouxxyy.test;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;


public class helloServlet implements Servlet {
    private ServletConfig config;

    // servlet创建时,调用一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");

        // 获取参数测试
//        System.out.println(servletConfig.getInitParameter("p1"));
//        Enumeration<String> e = servletConfig.getInitParameterNames();
//        while (e.hasMoreElements()) {
//            System.out.println(e.nextElement());
//        }
        this.config = servletConfig;
    }

    //  获取servlet的配置信息
    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return config;
    }

    // 结束请求时，就会被调用一次
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }

    // 一般没什么用，自己定义的
    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    // servlet死时,会被调用一次
    @Override
    public void destroy() {
        System.out.println("destroy");

    }

    public helloServlet() {
        System.out.println("HelloServlet的构造器");
    }

    // 模拟GenericServlet中的方法
    public ServletContext getServletContext() {
        return config.getServletContext();
    }
}
