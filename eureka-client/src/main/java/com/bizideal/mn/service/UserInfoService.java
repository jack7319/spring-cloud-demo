package com.bizideal.mn.service;

import com.bizideal.mn.entity.UserInfo;
import com.bizideal.mn.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/12 11:30
 * @version: 1.0
 * @Description:
 */
@Service("userInfoService")
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Transactional
    public int insert(UserInfo userInfo) {
        int insert = userInfoMapper.insert(userInfo);
        return insert;
    }

    public UserInfo getById(int id) {
        UserInfo byId = userInfoMapper.getById(id);
        return byId;
    }
}
