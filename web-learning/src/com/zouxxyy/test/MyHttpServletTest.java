package com.zouxxyy.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletContext application = this.getServletContext();
//        // 存储域对象
//        application.setAttribute("name", "张三");
//
//        // 获取实际路径
//        String path =application.getRealPath("/index.jsp");
//        System.out.println(path);

        // 请求转发测试，留头不留体，可以看出这里路径没包含项目名
        // System.out.println("one servlet...");
        // resp.setHeader("aaa", "AAA"); // 响应头
        // resp.getWriter().print("hello, one servlet!"); // 响应体，正常情况这里不设置响应体
        // req.getRequestDispatcher("/myHttpServletTestGet").forward(req, resp); // 等同于调用另一个Servlet

        // 设置值，传给转发的请求
        req.setAttribute("oneAttribute", "zzz");

        // 请求包含测试，留头又留体
        System.out.println("one servlet...");
        resp.setHeader("aaa", "AAA"); // 响应头
        resp.getWriter().print("hello, one servlet!"); // 响应体
        req.getRequestDispatcher("/myHttpServletTestGet").include(req, resp); // 这里是include

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost....");
    }
}
