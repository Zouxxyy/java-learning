package com.zouxxyy.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ResponseServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Response测试

        // 重定向测试1，可以看出这里包含了项目名
        // resp.setHeader("Location", "/servlet_learning_war_exploded/hello");
        // resp.setStatus(302);

        // 重定向测试2
        // resp.sendRedirect("/servlet_learning_war_exploded/hello");

        // Refresh测试
        // resp.setHeader("Refresh", "5;URL=/servlet_learning_war_exploded/hello");

        // 设置不缓存
        // resp.setHeader("Cache-Control", "no-cache");
        // resp.setHeader("pragma", "no-cache");
        // resp.setDateHeader("expires", -1);

        // Request测试
        // System.out.println("IP: " + req.getRemoteAddr());
        // System.out.println("请求方式： " + req.getMethod());
        // System.out.println(req.getHeader("User-Agent"));

        // 获取URL后面的参数
        System.out.println("GET： " + req.getParameter("name1"));
        System.out.println("GET： " + req.getParameter("name2"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby"); // 获取多值
        System.out.println(username + ", " + password + ", " + Arrays.toString(hobby));
    }
}
