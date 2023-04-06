package com.itheima.service;

import com.itheima.pojo.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> selectALL();
    // 添加功能
    void  addBrand(Brand brand);
    void deleteByIds(int[] ids);
}
