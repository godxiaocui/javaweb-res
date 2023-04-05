package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
替换httpservlet，通过反射进行方法分发
 */
public class BaseServlet extends HttpServlet {

    // 重写service方法
    // 根据请求进行方法分发
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 根据访问路径获取方法名
        String requestURI = req.getRequestURI();
        // 截断
        int i = requestURI.lastIndexOf('/');
        // 获取到servlet
        String methodname = requestURI.substring(i+1);
        System.out.println(methodname);
        // 执行方法，主要是利用反射，获取到brand的方法的字节码文件class
        // this的理解很关键，这里的this不是base的，而是谁调用我，this代表谁，如果是brand调用，那么this代表的就是brand
        Class<? extends BaseServlet> aClass = this.getClass();
        System.out.println(aClass);

        // 获取method对象
        try {
            Method method = aClass.getMethod(methodname, HttpServletRequest.class, HttpServletResponse.class);
            // 执行方法
            Object invoke = method.invoke(this,req, resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        // 执行方法


    }
}
