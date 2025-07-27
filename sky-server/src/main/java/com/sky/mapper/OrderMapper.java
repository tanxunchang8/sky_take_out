package com.sky.mapper;


import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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


}
