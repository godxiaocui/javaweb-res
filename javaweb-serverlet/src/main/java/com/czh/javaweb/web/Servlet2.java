package com.czh.javaweb.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * 解决中文乱码问题
 */
@WebServlet("/req4")
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //2。post解决中文乱码
        request.setCharacterEncoding("UTF-8");
        //1。获取username
        String username = request.getParameter("username");
        System.out.println(username);

        //3。 get方式是getQueryString,将获取的乱码改为字节
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        //将字节输出
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
