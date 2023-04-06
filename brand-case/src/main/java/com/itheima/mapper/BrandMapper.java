package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
@Select("select * from javaweb.tb_brand")
@ResultMap("brandResultMap")
    List<Brand> selectALL();
// 添加
@Insert("insert into javaweb.tb_brand values(null,#{brand.brandName},#{brand.companyName},#{brand.ordered},#{brand.description},#{brand.status}) ")
    @ResultMap("brandResultMap")
void addBrand(@Param("brand") Brand brand);

// 删除
    void deleteByIds(@Param("ids") int [] ids);
}
