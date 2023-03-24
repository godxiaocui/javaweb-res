package com.czh.javaweb.web;

import com.czh.javaweb.pojo.Brand;
import com.czh.javaweb.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    private   BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //  处理乱码问题

            request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        Brand brand = new Brand(Integer.parseInt(id), brandName, companyName, Integer.parseInt(ordered), description,Integer.parseInt(status));

        brandService.updateBrand(brand);
        // 重定向到servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
