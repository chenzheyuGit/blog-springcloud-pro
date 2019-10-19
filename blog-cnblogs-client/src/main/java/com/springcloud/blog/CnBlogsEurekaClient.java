package com.springcloud.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CnBlogsEurekaClient {

	 public static void main(String[] args) {
	        SpringApplication.run( CnBlogsEurekaClient.class, args );
	    }
}
