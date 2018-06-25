package com.cloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.service.HelloService;

@RestController
public class HelloControler {

	@Resource
	HelloService helloService;
	
	@RequestMapping(value="/hello")
	public String hi(@RequestParam String name) {
		return helloService.hi(name);
	}
}
