package com.czh.javaweb.web;

import com.czh.javaweb.Utils.SqlSessionUtils;
import com.czh.javaweb.mapper.UserMapper;
import com.czh.javaweb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接受数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        // mybatis
        SqlSessionFactory sqlsessionFactory = SqlSessionUtils.getSqlsessionFactory();
        SqlSession sqlSession = sqlsessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectUserName(username);
        if (user1 != null){
            response.getWriter().write("已存在");
        }else {
            mapper.addUser(user);
            sqlSession.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
