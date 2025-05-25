package com.sky.controller.admin;
import com.sky.dto.DishDTO;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: sky-take-out
 * @BelongsPackage: com.sky.controller.admin
 * @Author: tan
 * @CreateTime: 2025-05-25  17:04
 * @Description: 菜品管理
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品相关接口")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    /*
     * @description: 新增菜品
     * @Author: tan
     * @Date: 2025/5/25 17:09
     * @Param :
     * @return: com.sky.result.Result
     **/
    @PostMapping
    @ApiOperation("新增菜品")
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("新增菜品: {}" , dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }
}
