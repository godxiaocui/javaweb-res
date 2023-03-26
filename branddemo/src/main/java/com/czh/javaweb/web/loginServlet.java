package com.czh.javaweb.web;

import com.czh.javaweb.pojo.User;
import com.czh.javaweb.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    // 创建一个service对象
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //用户名进行查询
        // 获取复选框
        String remember = request.getParameter("remember");
        User user = service.login(username, password);
        if (user != null ){
            // 判断用户是否勾选复选框
            if ("1".equals(remember)){
                // 发送cookie到浏览器
                // 获取两个cookie
                Cookie username1 = new Cookie("username", username);
                Cookie password1 = new Cookie("password", password);
                // 设置cookie时间
                username1.setMaxAge(60*60*24*7);
                password1.setMaxAge(60*60*24*7);
                //发送cookie
                response.addCookie(username1);
                response.addCookie(password1);
            }
        //  登陆成功
            // 重定向
            // 登陆成功保存用户,保存这个user对象到session，将来可以在jsp中user的对象直接使用
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");
        // 判断用户是否勾选复选框

        }else {
        // 登陆失败
            // 转发
            // 存储错误信息到request
            request.setAttribute("login_msg","用户密码错误");
            String contextPath = request.getContextPath();
            //跳转回jsp
            request.getRequestDispatcher(contextPath+"/login.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
