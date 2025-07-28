package com.sky.task;

import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @BelongsProject: sky-take-out
 * @BelongsPackage: com.sky.task
 * @Author: tan
 * @CreateTime: 2025-07-28  22:47
 * @Description: TODO
 */
@Component
@Slf4j
public class OrderTask {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * description: 处理超时订单的方法
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/28 22:47
     * @return: void
     */
    @Scheduled(cron = "0 * * * * ?") //每分钟触发一次
    public void processTimeoutOrder() {
        log.info("定时处理超时订单 :{}", LocalDateTime.now());

        val time = LocalDateTime.now().plusMinutes(-15);
        //select * from orders where status = ? and order_time < (当前时间 - 15分钟)
        List<Orders> ordersList = orderMapper.getByStatusAndOrderTime(Orders.PENDING_PAYMENT, time);

        if (ordersList != null && ordersList.size() > 0) {
            for (Orders orders : ordersList) {
                orders.setStatus(Orders.CANCELLED);
                orders.setCancelReason("订单超时，自动取消");
                orders.setCancelTime(LocalDateTime.now());
                orderMapper.update(orders);
            }
        }
    }

    /**
     * description: 处理一直处理配送中状态的订单
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/28 23:01
     * @return: void
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void processDeliveryOrder() {
        log.info("定时处理处于配送中的订单 :{}", LocalDateTime.now());

        val time = LocalDateTime.now().plusMinutes(-60);

        List<Orders> ordersList = orderMapper.getByStatusAndOrderTime(Orders.DELIVERY_IN_PROGRESS,time);

        if (ordersList != null && ordersList.size() > 0) {
            for (Orders orders : ordersList) {
                orders.setStatus(Orders.COMPLETED);
                orders.setCancelReason("订单超时，自动取消");
                orders.setCancelTime(LocalDateTime.now());
                orderMapper.update(orders);
            }
        }

    }
}
