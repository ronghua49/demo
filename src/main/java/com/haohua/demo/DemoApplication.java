package com.haohua.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCaching
@CacheConfig(cacheNames = {"cashTest"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello/{name}")
    @CachePut(key = "guest")
    public String hello(@PathVariable String name) {
        return  name;
    }

    @GetMapping("/hello/again/{param}")
    @Cacheable(key = "guest")
    public String helloAgain(@PathVariable String param){
        return param;
    }

    @GetMapping("/hello/del")
    @Cacheable(key = "guest")
    public void helloDel(){
    }

}
