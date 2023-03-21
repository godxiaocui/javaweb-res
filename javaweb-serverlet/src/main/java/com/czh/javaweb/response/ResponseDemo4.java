package com.czh.javaweb.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * 相应输入流 设置字节数据的响应体
 */
@WebServlet("/ResponseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // io流读取文件。一边读取一边输出的形式，具体可以温习一下输入输出流
        FileInputStream fileInputStream = new FileInputStream("/Users/cuizhiheng/java_homework/javaweb/javaweb-serverlet/src/main/java/com/czh/javaweb/response/strewberrybear.jpeg");
        // reponse 的输出流
        ServletOutputStream outputStream = response.getOutputStream();

//        byte[] bytes = new byte[2048];
//        int len=0;
//        while ((len=fileInputStream.read(bytes))!=-1){
//            outputStream.write(bytes,0,len);
//        }
        // 快速拷贝
        IOUtils.copy(fileInputStream,outputStream);
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
