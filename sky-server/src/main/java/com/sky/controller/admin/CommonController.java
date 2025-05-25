package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @BelongsProject: sky-take-out
 * @BelongsPackage: com.sky.controller.admin
 * @Author: tan
 * @CreateTime: 2025-05-07  19:33
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {
    /*
     * @description:文件上传
     * @Author: tan
     * @Date: 2025/5/7 19:36
     * @Param :
     * @return: com.sky.result.Result<java.lang.String>
     **/
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传： {}", file);

        return Result.success();
    }
}
