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

import java.util.List;

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

    /**
     * description: 根据菜品id集合批量删除菜品
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/5/31 21:09
     * @Param ids:
     * @return: void
     */
    void deleteByIds(List<Long> ids);

    /**
     * description: 根据id动态修改菜品
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/5/31 21:48
     * @Param dish:
     * @return: void
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Dish dish);


    /**
     * 动态条件查询菜品
     * @param dish
     * @return
     */
    List<Dish> list(Dish dish);


    /**
     * 根据套餐id查询菜品
     * @param setmealId
     * @return
     */
    @Select("select a.* from dish a left join setmeal_dish b on a.id = b.dish_id where b.setmeal_id = #{setmealId}")
    List<Dish> getBySetmealId(Long setmealId);
}
