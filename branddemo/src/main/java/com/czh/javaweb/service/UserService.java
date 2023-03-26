package com.czh.javaweb.service;

import com.czh.javaweb.mapper.UserMapper;
import com.czh.javaweb.pojo.User;
import com.czh.javaweb.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    // 登陆方法
    public User login(String username,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       User user= mapper.select(username,password);
       sqlSession.close();
       return  user;
    }

    // 注册方法
    public boolean register(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u=mapper.selectByUsername(user.getUsername());
        if (u==null) {
            // 用户可以注册
            mapper.add(user);

        }
        sqlSession.close();
        return u== null;

    }
}
