package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @FileName UserMapper
 * @Description: 用户mapper接口
 * @Author tan
 * @date 2025-07-07
 **/
@Mapper
public interface UserMapper {

    /**
     * description: 根据openid查询用户
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/7 23:25
     * @Param openid:
     * @return: com.sky.entity.User
     */
    @Select("select * from user where openid = #{openid}")
    User getByOpenid(String openid);

    /**
     * description: 插入数据
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/7 23:29
     * @Param user: 
     * @return: void
     */
    void insert(User user);

    /**
     * description: 根据id查询用户
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/27 22:35
     * @Param userId:
     * @return: com.sky.entity.User
     */
    @Select("select * from user where id = #{id};")
    User getById(Long userId);
}
