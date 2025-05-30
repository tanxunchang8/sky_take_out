package com.sky.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;  // MyBatis 原生注解
import java.util.List;

/**
 * @FileName SetmealDishMapper
 * @Description
 * @Author tan
 * @date 2025-05-30
 **/
@Mapper
public interface SetmealDishMapper {
   
    /**
     * description: 根据菜品id查询对应的套餐id
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/5/30 23:10
     * @Param dishIds: 
     * @return: java.util.List<java.lang.Long>
     */
    // select setmeal_id from setmeal_dish where dish_id in (1,2,3,4)
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);
}
