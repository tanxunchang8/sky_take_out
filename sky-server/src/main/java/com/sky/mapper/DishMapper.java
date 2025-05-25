package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /*
     * @description: 插入菜品数据
     * @Author: tan
     * @Date: 2025/5/25 17:28
     * @Param :
     * @return: void
     **/
    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);
}
