package com.czh.javaweb.service;

import com.czh.javaweb.mapper.BrandMapper;
import com.czh.javaweb.pojo.Brand;
import com.czh.javaweb.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    //
    public List<Brand> selectAll(){

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return  brands;
    }

    public  void addBrand(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.close();
    }

    public Brand selectById(int id){

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return  brand;
    }

    public  void updateBrand(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.close();
    }

    public void deleteById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.close();
    }
}
