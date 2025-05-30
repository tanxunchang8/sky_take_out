package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
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

    /*
     * @description: 菜品分页查询
     * @Author: tan
     * @Date: 2025/5/30 21:46
     * @Param :
     * @return: com.github.pagehelper.Page<com.sky.vo.DishVO>
     **/
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);
}
