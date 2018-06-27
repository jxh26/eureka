package com.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.cloud.bean.MyBean;

@Configuration
public class MyConfig {
	
	@Bean("myBean")
	@Scope("prototype")
	public MyBean createMyBean() {
		return new MyBean();
	}

}
