package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dhl
 * @datetime 2021/8/3  16:18
 */
@Controller
public class RouterController {

    @RequestMapping({"/", "/index.html", "/index", "/index.htm"})
    public String index(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "view/login";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id")int id) {
        return "view/level1/" + id;
    }
    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id")int id) {
        return "view/level2/" + id;
    }
    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id")int id) {
        return "view/level3/" + id;
    }
}