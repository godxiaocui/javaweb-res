package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService=new BrandServiceImpl();
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 用service查询
        List<Brand> brands=brandService.selectALL();
        // 转为json

        String s = JSON.toJSONString(brands);
        // 写数据.
        // 涉及中文需要先设置为中文
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);

    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接受数据
        BufferedReader reader = request.getReader();
        String s1 = reader.readLine(); // json 字符串
        // json转为Brand对象
        Brand brand = JSON.parseObject(s1, Brand.class);

        brandService.addBrand(brand);
        response.getWriter().write("success");

    }
}
