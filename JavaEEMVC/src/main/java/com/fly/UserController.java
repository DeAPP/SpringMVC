package com.fly;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    /*GET请求：查询用户*/
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public void queryUser(@PathVariable("id") Integer userId) {
        System.out.println("GET-user" + userId);
    }

    /*POST请求：添加用户*/
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(User user, HttpServletRequest request) {
        request.setAttribute("user", user);
        System.out.println("POST-user" + user);
        return "success";
    }

    /*DELETE请求：删除用户*/
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Integer userId) {
        System.out.println("DELETE-user" + userId);
    }

    /*PUT请求：更新用户*/
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable("id") Integer userId) {
        System.out.println("PUT-user" + userId);
    }
}

