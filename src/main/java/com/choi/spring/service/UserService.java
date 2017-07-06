package com.choi.spring.service;

import com.choi.spring.domain.HttpResponse;
import com.choi.spring.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by choi on 2017. 6. 4..
 */
@Transactional
public interface UserService {

    @Transactional(readOnly = true)
    public ArrayList<User> getUsers();
    @Transactional(readOnly = true)
    public User getUser(String name);

    public HttpResponse insertUser(User user);
    public HttpResponse deleteUser(String name);
}
