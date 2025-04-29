package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;

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
}
