package com.czh.javaweb.mapper;


import com.czh.javaweb.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {


    /**
     * 根据用户名和密码查询用户对象
     * @param username
     * @param password
     * @return
     */
    @Select("select * from javaweb.tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password")  String password);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from javaweb.tb_user where username = #{username}")
    User selectByUsername(String username);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into javaweb.tb_user values(null,#{username},#{password})")
    void add(User user);
}
