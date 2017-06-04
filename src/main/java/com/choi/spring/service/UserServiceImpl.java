package com.choi.spring.service;

import com.choi.spring.domain.HttpResponse;
import com.choi.spring.domain.User;
import com.choi.spring.persistence.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by choi on 2017. 6. 4..
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private UserMapper userMapper;

    @Override
    public HttpResponse insertUser(User user) {
        int resultCode = userMapper.insertUser(user.getName(), user.getPw());
        if (resultCode < 0) {
            return new HttpResponse(false, resultCode);
        }
        return new HttpResponse(true, resultCode);
    }

    @Override
    public ArrayList<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public User getUser(String name) {
        return userMapper.getUser(name);
    }

    @Override
    public HttpResponse deleteUser(String name) {
        try {
            userMapper.deleteUser(name);
        } catch (Exception e) {
            return new HttpResponse(false, "처리되지 않았습니다.");
        }
        return new HttpResponse(true, "정상적으로 처리되었습니다.");
    }
}
