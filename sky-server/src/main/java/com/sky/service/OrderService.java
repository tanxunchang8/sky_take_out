package com.sky.service;


import com.sky.dto.OrdersPaymentDTO;
import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderPaymentVO;
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

    /**
     * 订单支付
     * @param ordersPaymentDTO
     * @return
     */
    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception;

    /**
     * 支付成功，修改订单状态
     * @param outTradeNo
     */
    void paySuccess(String outTradeNo);

    /**
     * description: 客户催单
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/30 22:12
     * @Param id:
     * @return: void
     */
    void reminder(Long id);
}
