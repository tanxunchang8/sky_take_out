package com.sky.service;


import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

/**
 * @FileName ShoppingCartService
 * @Description: 操纵购物车的业务层接口
 * @Author tan
 * @date 2025-07-18
 **/

public interface ShoppingCartService {

    /**
     * description: 添加购物车
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/18 22:21
     * @Param shoppingCartDTO:
     * @return: void
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    /**
     * description: 查看购物车
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/20 20:46
     * @return: java.util.List<com.sky.entity.ShoppingCart>
     */
    List<ShoppingCart> showShoppingCart();

    /**
     * description: 清空购物车
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/20 21:10
     * @return: void
     */
    void cleanShoppingCart();
}
