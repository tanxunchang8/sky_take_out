package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.ReportService;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @BelongsProject: sky-take-out
 * @BelongsPackage: com.sky.controller.admin
 * @Author: tan
 * @CreateTime: 2025-07-31  22:39
 * @Description: 数据统计
 */
@RestController
@RequestMapping("/admin/report")
@Api(tags = "数据统计相关接口")
@Slf4j
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * description: 营业额统计
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/31 22:43
     * @Param begin:
     * @Param end:
     * @return: com.sky.result.Result<com.sky.vo.TurnoverReportVO>
     */
    @GetMapping("/turnoverStatistics")
    @ApiOperation("营业额统计")
    public Result<TurnoverReportVO> turnoverStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate end){
        log.info("营业额数据统计: {},{}", begin, end);
        return Result.success(reportService.getTurnoverStatistics(begin,end));
    }


    /**
     * description: 用户统计
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/8/1 21:00
     * @Param begin:
     * @Param end:
     * @return: com.sky.result.Result<com.sky.vo.TurnoverReportVO>
     */
    @GetMapping("/userStatistics")
    public Result<UserReportVO> userStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate end) {
        log.info("用户数据统计: {},{}", begin, end);
        return Result.success(reportService.getUserStatistics(begin,end));
    }

}
