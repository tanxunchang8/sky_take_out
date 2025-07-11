package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: sky-take-out
 * @BelongsPackage: com.sky.controller.admin
 * @Author: tan
 * @CreateTime: 2025-06-28  14:42
 * @Description: TODO
 */
@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
@Slf4j

public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * description: 设置店铺的营业状态
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/6/28 14:47
     * @Param status:
     * @return: com.sky.result.Result
     */
    @PutMapping("/{status}")
    @ApiOperation("设置店铺的营业状态")
    public Result setStatus(@PathVariable Integer status) {
        log.info("设置店铺的营业状态为：{}", status == 1 ? "营业中" : "打烊中");
        redisTemplate.opsForValue().set(KEY, status);
        return Result.success(status);
    }
    /**
     * description: 获取店铺的营业状态
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/6/28 14:50

     * @return: com.sky.result.Result<java.lang.Integer>
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("获取到店铺的营业状态为:{}", status == 1 ? "营业中" : "打烊中");
        return  Result.success(status);
    }
}
