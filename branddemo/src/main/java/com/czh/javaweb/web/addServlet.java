package com.czh.javaweb.web;

import com.czh.javaweb.pojo.Brand;
import com.czh.javaweb.service.BrandService;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
    private   BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //  处理乱码问题

            request.setCharacterEncoding("utf-8");
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        Brand brand = new Brand(null, brandName, companyName, Integer.parseInt(ordered), description,Integer.parseInt(status));

        brandService.addBrand(brand);
        // 重定向到servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
