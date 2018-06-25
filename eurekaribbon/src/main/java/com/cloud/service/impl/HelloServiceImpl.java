package com.cloud.service.impl;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cloud.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	

	@Override
	public String hi(String name) {
		return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name, String.class);
	}

}
