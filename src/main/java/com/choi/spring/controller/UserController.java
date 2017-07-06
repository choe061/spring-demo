package com.choi.spring.controller;

import com.choi.spring.domain.HttpResponse;
import com.choi.spring.domain.User;
import com.choi.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by choi on 2017. 6. 2..
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<User> list() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public User profile(@PathVariable String name) {
        return userService.getUser(name);
    }

    @RequestMapping(value = "/up", method = RequestMethod.POST)
    @ResponseBody
    public HttpResponse signup(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpResponse delete(@PathVariable String name) {
        return userService.deleteUser(name);
    }

}
