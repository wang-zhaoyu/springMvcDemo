package com.wangzhaoyu.service.impl;

import com.wangzhaoyu.dao.TestMapper;
import com.wangzhaoyu.pojo.User;
import com.wangzhaoyu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangzhaoyu on 2016/10/12.
 */
@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestMapper testDao;
    @Override
    public List<User> queryAll() {
        return testDao.queryAll();
    }
}
