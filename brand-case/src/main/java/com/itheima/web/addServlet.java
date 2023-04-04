package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {

    // 可以动态的切换实现类，好处是可以有多个实现类，但是因为继承的同一个接口，接口的不用改

    private BrandService brandService=new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接受数据
        BufferedReader reader = request.getReader();
        String s1 = reader.readLine(); // json 字符串
        // json转为Brand对象
        Brand brand = JSON.parseObject(s1, Brand.class);

        brandService.addBrand(brand);
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
