package com.aduiduidui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谨漫Kinman
 * @version 1.0
 */
// @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@RestController
public class HelloController {
    // @RequestMapping注解用于映射请求URL和请求方法
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello World!");
        return "Hello World!";
    }
}
