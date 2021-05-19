package com.fly.controller;


import com.dao.UserMapper;
import com.fly.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.fly.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FlyController {

    @RequestMapping(value = "/coco", method = RequestMethod.GET)
    public String cocoGet() throws IOException {
        SqlSessionFactory factory = CommonHelper.getSqlSessionFactory();
        SqlSession openSession = factory.openSession();
        try {
            //不推荐使用
            //User user = openSession.selectOne("com.dao.UserMapper.getUserById", 1);
            //推荐使用Dao接口的代理类
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);
            System.out.println(user);
        } finally {
            openSession.close();
        }
        return "success";
    }

    @RequestMapping(value = "/insert")
    public String insertUser() {
        SqlSessionFactory factory = CommonHelper.getSqlSessionFactory();
        SqlSession openSession = factory.openSession();
        try {
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            User user = new User();
            user.setNickname("你好");
            user.setUsername("王二狗");
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("username", "刘之");
            objectMap.put("nickname", "王二狗");
            mapper.insertUser(objectMap);
            //int v1 = mapper.insertUser(user.getNickname(), user.getUsername());
            //int v2 = mapper.insertUser(user);
            //System.out.println(v1);
        } finally {
            openSession.commit();
            openSession.close();
        }
        return "success";
    }


    @RequestMapping(value = "/coco2")
    public String cocoPost(HttpServletRequest request, HttpServletResponse response) {
        return "success";
    }

    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "nickName") String userName) {
        System.out.println("userName=" + userName);
        return "success";
    }

    @RequestMapping(value = "/testServeltWrite")
    public void testServeltWrite(Writer writer) {
        try {
            writer.write("你好世界");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String language, HttpServletRequest request) {
        request.setAttribute("language", language);
        return "success";
    }

    @RequestMapping(value = "/testPOJO")
    public String testPOJO(User user) {
        System.out.println(user);
        return "success";
    }
}
