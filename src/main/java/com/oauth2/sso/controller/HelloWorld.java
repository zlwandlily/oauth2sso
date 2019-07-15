package com.oauth2.sso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloWorld
 * @Description
 * @Date 2019/7/15 9:27
 * @Created by ZLW
 * @Author zlw
 */
@RestController
public class HelloWorld {

  @RequestMapping("/hello")
  public String helloWorld(@RequestParam String name) {
    return "测试基础服务连通性：" + name;
  }
}
