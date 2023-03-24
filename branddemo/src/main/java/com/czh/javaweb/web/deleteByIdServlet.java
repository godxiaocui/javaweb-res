package com.czh.javaweb.web;

import com.czh.javaweb.pojo.Brand;
import com.czh.javaweb.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteByIdServlet")
public class deleteByIdServlet extends HttpServlet {
    private  BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        brandService.deleteById(id);
        List<Brand> brands = brandService.selectAll();
        request.setAttribute("brands",brands);


        // 转发
        request.getRequestDispatcher("/brand.jsp").forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
