package com.czh.javaweb.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 还有一点关键的是保证工厂只创建一次
 */
public class SqlSessionUtils {
    private static SqlSessionFactory sqlSessionFactory;
    //静态代码块只在类加载的时候执行一次
    {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

    }
    public static SqlSessionFactory getSqlsessionFactory(){
        return sqlSessionFactory;
    }
}
