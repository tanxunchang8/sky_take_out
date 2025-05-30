package com.sky.service;


import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    /*
     * @description: 菜品分页查询
     * @Author: tan
     * @Date: 2025/5/30 21:42
     * @Param :
     * @return: com.sky.result.PageResult
     **/
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /*
     * @description: 菜品批量删除
     * @Author: tan
     * @Date: 2025/5/30 22:36
     * @Param :
     * @return: void
     **/
    void deleteBatch(List<Long> ids);
}
