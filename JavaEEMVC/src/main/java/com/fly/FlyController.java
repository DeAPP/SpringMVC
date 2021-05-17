package com.fly;


import com.fly.bean.User;
import com.util.CommonHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@Controller
public class FlyController {
    @RequestMapping(value = "/coco", method = RequestMethod.GET)
    public String cocoGet() throws IOException {
        SqlSessionFactory factory = CommonHelper.getSqlSessionFactory();
        SqlSession openSession = factory.openSession();
        try {
            User user = openSession.selectOne("com.fly.mybatis.dao.UserMapper.getUserById", 1);
            System.out.println(user);
        } finally {
            openSession.close();
        }
        return "success";
    }


    @RequestMapping(value = "/coco", method = RequestMethod.POST)
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
