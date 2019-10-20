package com.springcloud.blog;
import javax.xml.crypto.dsig.XMLObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "returnError")
    public String get48HoursTopViewPosts(String itemCount) {
        return restTemplate.getForObject("http://cnblogs-client/cnblogs/get48HoursTopViewPosts/"+itemCount,String.class);
    }

    public String returnError(String itemCount) {
        return itemCount+" error";
    }
}
