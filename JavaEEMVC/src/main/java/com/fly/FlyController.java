package com.fly;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FlyController {
    @RequestMapping(value="/coco",method= RequestMethod.GET)
    public String sayHi(){
        System.out.println(11122);
        return "/WEB-INF/pages/success.jsp";
    }
}
