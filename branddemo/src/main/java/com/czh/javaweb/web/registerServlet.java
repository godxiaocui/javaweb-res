package com.czh.javaweb.web;

import com.czh.javaweb.pojo.User;
import com.czh.javaweb.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 注册
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 用户验证码
        String checkCode = request.getParameter("checkCode");
        // 程序生产的验证码
        HttpSession session = request.getSession();
        String verifycode = (String)session.getAttribute("verifycode");
        if (!verifycode.equalsIgnoreCase(checkCode)){
            request.setAttribute("register_msg", "验证错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        //新建一个user对象
        User user = new User(null, username, password);
        String contextPath = request.getContextPath();
        //注册成功
        if(service.register(user)  ){
            request.setAttribute("register_msg","注册成功");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }else {
            request.setAttribute("register_msg", "用户名重复");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
