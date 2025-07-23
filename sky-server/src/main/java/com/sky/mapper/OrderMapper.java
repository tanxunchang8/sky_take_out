package com.sky.mapper;


import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @FileName OderMapper
 * @Description: TODO
 * @Author tan
 * @date 2025-07-21
 **/
@Mapper
public interface OrderMapper {

    /**
     * description: 插入订单数据
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/23 21:58
     * @Param orders:
     * @return: void
     */
    void insert(Orders orders);


}
