package com.sky.service;


import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @FileName DishService
 * @Description
 * @Author tan
 * @date 2025-05-25
 **/

public interface DishService {

    /*
     * @description: 新增菜品和对应的口味
     * @Author: tan 
     * @Date: 2025/5/25 17:12
     * @Param : 
     * @return: void
     **/
    public void saveWithFlavor(DishDTO dishDTO);
}
