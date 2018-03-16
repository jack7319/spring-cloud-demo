package com.bizideal.mn.mapper;

import com.bizideal.mn.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/12 11:28
 * @version: 1.0
 * @Description:
 */
public interface UserInfoMapper {

    @Insert("INSERT INTO user_info(name) VALUES (#{name})")
    int insert(UserInfo userInfo);

    @Select("SELECT * FROM user_info WHERE id = #{id}")
    UserInfo getById(int id);
}