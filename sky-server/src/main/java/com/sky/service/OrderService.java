package com.sky.service;


import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderSubmitVO;

/**
 * @FileName OrderService
 * @Description: TODO
 * @Author tan
 * @date 2025-07-21
 **/
public interface OrderService {

    /**
     * description: 用户下单
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/21 23:23
     * @Param ordersSubmitDTO:
     * @return: com.sky.vo.OrderSubmitVO
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);
}
