package com.czh.javaweb.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/ResponseDemo2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo2");
        //设置响应状态码
        response.setStatus(302);
        //1。 设置响应头

        response.setHeader("Location","/ResponseDemo1");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //简化方法
        response.sendRedirect(contextPath+"/ResponseDemo1");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
