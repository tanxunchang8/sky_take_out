package com.sky.mapper;


import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @FileName ShoppingCartMapper
 * @Description: TODO
 * @Author tan
 * @date 2025-07-18
 **/
@Mapper
public interface ShoppingCartMapper {
    
    /**
     * description: 动态条件查询
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/18 22:34
     * @Param shoppingCart: 
     * @return: java.util.List<com.sky.entity.ShoppingCart>
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * description: 根据id修改商品数量
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/18 22:45
     * @Param shoppingCart:
     * @return: void
     */
    @Update("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart shoppingCart);

    /**
     * description: 插入购物车数据
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/18 23:07
     * @Param shoppingCart:
     * @return: void
     */
    @Insert("insert into shopping_cart(name, user_id, dish_id, setmeal_id, dish_flavor, number, amount,  image, create_time) " +
            " values (#{name},#{userId},#{dishId},#{setmealId},#{dishFlavor},#{number},#{amount},#{image},#{createTime})")
    void insert(ShoppingCart shoppingCart);
}
