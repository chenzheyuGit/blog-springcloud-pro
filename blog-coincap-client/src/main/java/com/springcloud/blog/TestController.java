package com.springcloud.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.lang.Console;

@RestController
public class TestController {

    @Autowired
    TestInterface testInterface;

    @GetMapping(value = "/get48HoursTopViewPosts/{itemCount}",produces = "application/xml;charset=utf-8")
    public String get48HoursTopViewPosts(@PathVariable String itemCount) {
        
    	Console.log("conincap");
        
    	return testInterface.get48HoursTopViewPosts(itemCount);
        
    }
}
