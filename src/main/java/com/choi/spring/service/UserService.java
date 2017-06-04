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
    HttpResponse insertUser(User user);
    ArrayList<User> getUsers();
    User getUser(String name);
    HttpResponse deleteUser(String name);
}
