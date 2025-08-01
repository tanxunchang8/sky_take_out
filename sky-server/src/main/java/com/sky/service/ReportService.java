package com.sky.service;

import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;

/**
 * @FileName ReportService
 * @Description: TODO
 * @Author tan
 * @date 2025-07-31
 **/
public interface ReportService {

    /**
     * description: 统计指定时间区间内的营业额数据
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/31 22:47
     * @Param begin:
     * @Param end:
     * @return: com.sky.vo.TurnoverReportVO
     */
    TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);

    /**
     * description: 统计指定时间区间内的用户数据
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/8/1 21:02
     * @Param begin: 
     * @Param end: 
     * @return: com.sky.vo.TurnoverReportVO
     */
    UserReportVO getUserStatistics(LocalDate begin, LocalDate end);
}
