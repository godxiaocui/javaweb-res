package com.czh.javaweb.mapper;

import com.czh.javaweb.pojo.Brand;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有工作
     * @return
     */
    @Select("select * from javaweb.tb_brand")
    @ResultMap("brandResultMapper")
    List<Brand> selectAll();

}
