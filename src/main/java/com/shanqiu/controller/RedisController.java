package com.shanqiu.controller;

import com.shanqiu.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiyuefei on 2017/4/2.
 */
@RestController
public class RedisController {
    @Autowired
    RedisService redisService;
    @RequestMapping("/hello")
    public String Say(){
        redisService.set("qi","yuefei");
        redisService.add("test1","1234");
        redisService.add("test1","12345");
        redisService.add("test2","1234");
        redisService.difference("test1","test2");
        System.out.println( redisService.difference("test1","test2"));
        System.out.println( redisService.intersect("test1","test2"));
        System.out.println( redisService.intersect("test1","test2"));
        redisService.zAdd("z1","test1",10d);
        redisService.zAdd("z1","test2",11d);
        redisService.zAdd("z1","test3",15d);
        redisService.zAdd("z1","test3",13d);
        redisService.zAdd("z1","test4",14d);
        redisService.zAdd("z1","test5",12d);
        System.out.println( redisService.range("z1",2,4));
        return redisService.get("qi").toString();
    }
}
