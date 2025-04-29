package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /*
     * @description:插入员工数据
     * @Author: tan
     * @Date: 2025/4/29 15:16
     * @Param :
     * @return: void
     **/
    @Insert("insert into employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user, status) " +
            "values " +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status})")
    void insert(Employee employee);


    /*
     * @description:分页查询
     * @Author: tan
     * @Date: 2025/4/29 17:17
     * @Param :
     * @return: void
     **/
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
    
    /*
     * @description:根据主键动态修改属性
     * @Author: tan 
     * @Date: 2025/4/29 20:30
     * @Param : 
     * @return: void
     **/
    void update(Employee employee);
}
