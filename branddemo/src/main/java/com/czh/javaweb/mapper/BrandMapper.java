package com.czh.javaweb.mapper;

import com.czh.javaweb.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有工作
     * @return
     */
    @Select("select * from javaweb.tb_brand")
    @ResultMap("brandResultMapper")
    List<Brand> selectAll();
    @Insert("insert into javaweb.tb_brand values(null,#{brand.brandName},#{brand.companyName},#{brand.ordered},#{brand.description},#{brand.status})")
    void add(@Param("brand") Brand brand);
    @Select("select * from javaweb.tb_brand where id=#{id}")
    @ResultMap("brandResultMapper")
    Brand selectById(@Param("id") int id);
@Update("update tb_brand set brand_name = #{brand.brandName},company_name = #{brand.companyName},ordered = #{brand.ordered},description = #{brand.description},status = #{brand.status} where id = #{brand.id}")
@ResultMap("brandResultMapper")
    void update(@Param("brand") Brand brand);

@Delete( "delete from javaweb.tb_brand where id =#{id}")
@ResultMap("brandResultMapper")
    void deleteById(@Param("id") int id);
}
