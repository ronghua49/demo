package com.haohua.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCaching
@CacheConfig(cacheNames = {"cashTest"})
@ResponseBody
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello/{name}")
    @CachePut(key = "#name")
    public String hello(@PathVariable String name) {
        return  name;
    }

    @GetMapping("/hello/again/{name}")
	
    @Cacheable(key = "#name")
    public String helloAgain(@PathVariable String name){
        return name;
    }

    @GetMapping("/hello/del")
    @Cacheable(key = "#p0")
    public void helloDel(){
    }

}
