package com.sky.mapper;


import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @FileName DishFlavorMapper
 * @Description
 * @Author tan
 * @date 2025-05-25
 **/
@Mapper
public interface DishFlavorMapper {

    /*
     * @description: 批量加入口味数据
     * @Author: tan
     * @Date: 2025/5/25 17:34
     * @Param :
     * @return: void
     **/
    void insertBatch(List<DishFlavor> flavors);
}
