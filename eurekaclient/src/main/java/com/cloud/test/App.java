package com.cloud.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cloud.bean.MyBean;
import com.cloud.config.MyConfig;
@ComponentScan
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		System.out.println(context.getBean(MyBean.class));
		System.out.println(context.getBean("myBean"));
		
		
	}
}
