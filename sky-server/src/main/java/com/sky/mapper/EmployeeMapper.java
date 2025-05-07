package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
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
    @AutoFill(value = OperationType.INSERT)
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
    @AutoFill(value = OperationType.UPDATE)
    void update(Employee employee);
    /*
     * @description:根据id查询员工信息
     * @Author: tan
     * @Date: 2025/5/7 10:55
     * @Param :
     * @return: com.sky.entity.Employee
     **/
    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);
}
