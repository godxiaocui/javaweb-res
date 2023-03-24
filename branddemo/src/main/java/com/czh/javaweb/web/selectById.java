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

@WebServlet("/selectByIdServlet")
public class selectById extends HttpServlet {
    private  BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Brand brand = brandService.selectById(id);

        request.setAttribute("brand",brand);
        // 转发

        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
