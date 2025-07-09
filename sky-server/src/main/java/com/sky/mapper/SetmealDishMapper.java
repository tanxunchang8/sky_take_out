package com.sky.mapper;


import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;  // MyBatis 原生注解
import org.apache.ibatis.annotations.Select;

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

    /**
     * 批量保存套餐和菜品的关联关系
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐id删除套餐和菜品的关联关系
     * @param setmealId
     */
    @Delete("delete from setmeal_dish where setmeal_id = #{setmealId}")
    void deleteBySetmealId(Long setmealId);


    /**
     * 根据套餐id查询套餐和菜品的关联关系
     * @param setmealId
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> getBySetmealId(Long setmealId);

}
