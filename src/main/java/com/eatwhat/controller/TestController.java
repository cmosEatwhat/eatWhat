package com.eatwhat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: zhangxin_an
 * @CreateDate: 2018/8/13 20:10
 */
@Controller
public class TestController {
    @ResponseBody
    @RequestMapping("/login/index.do")
    public String test(){
        System.out.println("test");
        return "test";
    }
}
