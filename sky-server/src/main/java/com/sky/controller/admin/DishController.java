package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /*
     * @description: 菜品分页查询
     * @Author: tan
     * @Date: 2025/5/30 22:00
     * @Param :
     * @return: com.sky.result.Result<com.sky.result.PageResult>
     **/
    @GetMapping("/page")
    @ApiOperation("菜品分页查询")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO){
        log.info("菜品分页查询：{}" , dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);

        return Result.success(pageResult);
    }

    /*
     * @description: 菜品批量删除
     * @Author: tan
     * @Date: 2025/5/30 22:34
     * @Param :
     * @return: com.sky.result.Result
     **/
    @DeleteMapping
    @ApiOperation("菜品批量删除")
    public Result delete(@RequestParam List<Long> ids){
        log.info("菜品批量删除: {}",ids);
        dishService.deleteBatch(ids);

        return Result.success();
    }


    /**
     * description: 根据id查询菜品
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/5/31 21:26
     * @Param id:
     * @return: com.sky.result.Result<com.sky.vo.DishVO>
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询菜品")
    public Result<DishVO> getById(@PathVariable Long id){
        log.info("根据id查询菜品 : {}",id);
        DishVO dishVO = dishService.getByIdWithFlavor(id);
        return Result.success(dishVO);
    }


    /**
     * description: 修改菜品
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/5/31 21:42
     * @Param dishDTO:
     * @return: com.sky.result.Result
     */
    @PutMapping
    @ApiOperation("修改菜品")
    public Result update(@RequestBody DishDTO dishDTO){
        log.info("修改菜品 : {}",dishDTO);
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }


}
