package com.zouxxyy.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyHttpServletTestGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = this.getServletContext();

        // 获取域对象
        // String name = (String) application.getAttribute("name");
        // System.out.println(name);
        // PrintWriter pw = resp.getWriter();
        // pw.print(name);

        System.out.println("next servlet...");
        resp.getWriter().print("hello, next servlet!");

        // 获取上一个请求的值
        System.out.println(req.getAttribute("oneAttribute"));

    }
}
