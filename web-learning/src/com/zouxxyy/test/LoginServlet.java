package com.zouxxyy.test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("zxy".equals(username)) {

            // 附加选项：设置cookie
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60);
            resp.addCookie(cookie);

            HttpSession session = req.getSession();
            // 成功，就加入session中
            session.setAttribute("username", username);
            // 重定向到成功界面
            resp.sendRedirect("/servlet_learning_war_exploded/sessionTest/succ1.jsp");
        }
        else {
            req.setAttribute("msg", "用户名或密码错误");
            // 转发回登陆界面
            RequestDispatcher qr = req.getRequestDispatcher("/sessionTest/login.jsp");
            qr.forward(req, resp);
        }
    }
}
