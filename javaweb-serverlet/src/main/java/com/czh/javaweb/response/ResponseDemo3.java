package com.czh.javaweb.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * 相应输入流 设置字符数据的响应体
 */
@WebServlet("/ResponseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // 响应的字符格式和字符集避免中文乱码
        response.setContentType("text/html;charset=utf-8");

        // 1。获取字符输出流
        PrintWriter writer = response.getWriter();
        // 2. 告诉浏览器响应的数据是HTMl格式
        //response.setHeader("content-type","text/html");
        writer.write("你好");
        writer.write("<h1>aaa<h1>");
        // 输出流不要关闭，跟随response的生命周期

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
