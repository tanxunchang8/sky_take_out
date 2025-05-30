package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
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

    /*
     * @description: 根据主键查询菜品
     * @Author: tan
     * @Date: 2025/5/30 22:42
     * @Param :
     * @return: void
     **/
    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);

    /**
     * description: 根据主键删除菜单数据
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/5/30 23:22
     * @Param id:
     * @return: void
     */
    @Delete("delete from dish where id = #{id}")
    void deleteById(Long id);
}
