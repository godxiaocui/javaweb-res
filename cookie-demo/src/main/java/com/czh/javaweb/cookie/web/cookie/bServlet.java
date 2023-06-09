package com.czh.javaweb.cookie.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * 获取cookie
 */
@WebServlet("/bServlet")
public class bServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 一个request会有多个cookie
        Cookie[] cookies = request.getCookies();

        for ( Cookie cookie: cookies
             ) {
            String name = cookie.getName();
            if("username".equals(name)){
                String value = cookie.getValue();
                // 中文解码
                String decode = URLDecoder.decode(value, "utf-8");
                System.out.println(decode);
                break;
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
