package com.sky.mapper;


import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @FileName OrderDetailMapper
 * @Description: TODO
 * @Author tan
 * @date 2025-07-21
 **/
@Mapper
public interface OrderDetailMapper {

    /**
     * description: 批量插入订单明细数据
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/23 22:17
     * @Param orderDetailList:
     * @return: void
     */
    void insertBatch(List<OrderDetail> orderDetailList);
}
