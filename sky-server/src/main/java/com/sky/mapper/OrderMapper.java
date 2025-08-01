package com.sky.mapper;


import com.github.pagehelper.Page;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    /**
     * 根据订单号和用户id查询订单
     * @param orderNumber
     * @param userId
     */
    @Select("select * from orders where number = #{orderNumber} and user_id= #{userId}")
    Orders getByNumberAndUserId(String orderNumber, Long userId);

    /**
     * 根据订单号查询订单
     * @param orderNumber
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    /**
     * 修改订单信息
     * @param orders
     */
    void update(Orders orders);


    /**
     * description: 根据订单状态和下单时间查询订单
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/28 22:53
     * @Param status: 
     * @Param orderTime: 
     * @return: java.util.List<com.sky.entity.Orders>
     */
    @Select("select * from orders where status = #{status} and order_time < #{orderTime}")
    List<Orders> getByStatusAndOrderTime(Integer status, LocalDateTime orderTime);


    /**
     * 分页条件查询并按下单时间排序
     * @param ordersPageQueryDTO
     */
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 根据id查询订单
     * @param id
     */
    @Select("select * from orders where id=#{id}")
    Orders getById(Long id);


    /**
     * description: 根据动态条件统计营业额数据
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/8/1 20:45
     * @Param map:
     * @return: java.lang.Double
     */
    Double sumByMap(Map map);
}
