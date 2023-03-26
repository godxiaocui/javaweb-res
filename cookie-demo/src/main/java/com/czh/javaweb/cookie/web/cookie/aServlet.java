package com.czh.javaweb.cookie.web.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 尝试写一个cookie
 */
@WebServlet("/aServlet")
public class aServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 尝试写一个cookie

        //设置存活时间
        //cookie不支持中文,要用URLEncoder进行转义
        String value="都是";
        String encode = URLEncoder.encode(value, "utf-8");
        Cookie cookie = new Cookie("username",encode);
        cookie.setMaxAge(60*60*24*7);
        response.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
