package com.bizideal.mn;

import com.bizideal.mn.entity.UserInfo;
import com.bizideal.mn.service.UserInfoService;
import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/12 12:08
 * @version: 1.0
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Application {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void insert() {
        userInfoService.insert(new UserInfo().setName("liulq"));
    }
}
