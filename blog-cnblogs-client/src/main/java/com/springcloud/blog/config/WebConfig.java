package com.springcloud.blog.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@ControllerAdvice
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    

    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	
        //静态资源放行
    	//registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    
    



}
