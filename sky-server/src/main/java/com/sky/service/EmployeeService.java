package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /*
     * @description:员工添加
     * @Author: tan
     * @Date: 2025/4/29 13:48
     * @Param :
     * @return: void
     **/
    void save(EmployeeDTO employeeDTO);
    /*
     * @description:分页查询
     * @Author: tan 
     * @Date: 2025/4/29 17:00
     * @Param : 
     * @return: com.sky.result.PageResult
     **/
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /*
     * @description:启用禁用员工账号
     * @Author: tan
     * @Date: 2025/4/29 20:26
     * @Param :
     * @return: void
     **/
    void startOrStop(Integer status, Long id);
}
