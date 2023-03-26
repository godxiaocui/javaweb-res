package com.czh.javaweb.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 拦截登陆界面
 */

@WebFilter("/*")
public class loginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 判断访问的路径是否和登陆相关
        String [] urls={"/login.jsp","/imgs/","/css/","loginServlet",
        "/register.jsp","registerServlet","checkCodeServlet"};
        //chain.doFilter(request, response);
        HttpServletRequest req = (HttpServletRequest) request;
        // 循环判断req的url是否是上述的一个
        String s = req.getRequestURL().toString();
        System.out.println(s);
        for (String u:urls
             ) {
            if (s.contains(u)){
                chain.doFilter(request,response);
                return;
            }
            // 否则直接直接return

        };
        // 判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        // 如果有放行，没有的话转发到登陆页面
        if(user!= null){
            chain.doFilter(request,response);
        }else {
            req.setAttribute("login_msg","您尚未登陆");
            req.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }
}
