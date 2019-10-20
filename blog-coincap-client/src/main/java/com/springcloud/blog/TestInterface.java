package com.springcloud.blog;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "cnblogs-client")
public interface TestInterface {
    @RequestMapping(value = "/cnblogs/get48HoursTopViewPosts/{itemCount}",method = RequestMethod.GET)
    String get48HoursTopViewPosts(@PathVariable(value = "itemCount") String itemCount);
}

