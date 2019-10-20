package com.springcloud.blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="test",produces = "application/xml;charset=utf-8")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping(value = "/get48HoursTopViewPosts/{itemCount}")
    public String get48HoursTopViewPosts(@PathVariable String itemCount) {
   
        return testService.get48HoursTopViewPosts( itemCount );
    }
}

