package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectALLServlet")
public class SelectALLServlet extends HttpServlet {

    // 可以动态的切换实现类，好处是可以有多个实现类，但是因为继承的同一个接口，接口的不用改

    private BrandService brandService=new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 用service查询
        List<Brand> brands=brandService.selectALL();
        // 转为json

        String s = JSON.toJSONString(brands);
        // 写数据.
        // 涉及中文需要先设置为中文
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
