package com.fly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@Controller
public class OutPutController {

    @RequestMapping("/modelAndView")
    public ModelAndView test() {
        //1.0 设置去哪个视图
        String viewName = "success";
        ModelAndView view = new ModelAndView(viewName);
        //2.0 设置要带什么数据去这个视图
        //方法数据实际是存放到request域中
        view.addObject("serverNow", new Date().toString());
        return view;
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map, Model model, ModelMap modelMap, BindingAwareModelMap bindingAwareModelMap) {
        System.out.println(map.getClass().getName());
        System.out.println(model.getClass().getName());
        System.out.println(modelMap.getClass().getName());

        map.put("serverNow", new Date().toString());
        model.addAttribute("serverNow2", new Date().toString());
        modelMap.put("serverNow3", new Date().toString());
        bindingAwareModelMap.put("serverNow4", new Date().toString());
        return "success";
    }

    @RequestMapping("/testMap2")
    public String testMap2(Map<String, Object> map, Model model, ModelMap modelMap, BindingAwareModelMap bindingAwareModelMap) {
        map.put("names", Arrays.asList("Tom", "Jerry", "Kite"));
        model.addAttribute("model", "org.springframework.ui.Model");
        modelMap.put("modelMap", "org.springframework.ui.ModelMap");

        System.out.println(map == model);
        System.out.println(map == modelMap);
        System.out.println(model == modelMap);
        System.out.println(modelMap == bindingAwareModelMap);

        System.out.println(map.getClass().getName());
        System.out.println(model.getClass().getName());
        System.out.println(modelMap.getClass().getName());
        System.out.println(bindingAwareModelMap.getClass().getName());
        return "success";
    }
}
