package com.sky.mapper;


import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
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

    /**
     * description: 根据菜品主键删除对应口味数据
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/5/30 23:25
     * @Param
     * @return: void
     */
    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);

    /**
     * description: 根据菜品id批量删除关联的口味数据
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/5/31 21:14
     * @Param dishIds:
     * @return: void
     */
    void deleteByDishIds(List<Long> dishIds);
}
