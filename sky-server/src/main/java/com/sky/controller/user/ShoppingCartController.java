package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: sky-take-out
 * @BelongsPackage: com.sky.controller.user
 * @Author: tan
 * @CreateTime: 2025-07-18  22:13
 * @Description: C端购物车相关接口
 */
@RestController
@RequestMapping("/user/shoppingCart")
@Slf4j
@Api(tags = "C端购物车相关接口")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * description: 添加购物车
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/18 22:18
     * @Param shoppingCartDTO:
     * @return: com.sky.result.Result
     */
    @PostMapping("/add")
    @ApiOperation("添加购物车")
    public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("添加购物车，商品信息为:{}", shoppingCartDTO);
        shoppingCartService.addShoppingCart(shoppingCartDTO);
        return Result.success();
    }

    /**
     * description: 查看购物车
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/20 20:44
     * @return: com.sky.result.Result<java.util.List < com.sky.entity.ShoppingCart>>
     */
    @GetMapping("/list")
    @ApiOperation("查看购物车")
    public Result<List<ShoppingCart>> list() {
        List<ShoppingCart> list = shoppingCartService.showShoppingCart();
        return Result.success(list);
    }


}
