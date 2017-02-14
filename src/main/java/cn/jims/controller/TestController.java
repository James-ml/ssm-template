package cn.jims.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jims on 2017/2/14.
 */
public class TestController {
    @RequestMapping("login")
    public String index(){
        return "login";
    }
}
