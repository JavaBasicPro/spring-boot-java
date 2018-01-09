package com.java.springbootjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJavaApplication.class, args);
	}
}
/*
*1、SpringBoot的作用：简化spring应用的初始搭建以及开发过程，可以开发jar -jar 方式启动运行的java应用；
图：User 访问--》Spring Boot 访问--》Spring
*快速生成项目地址：http://start.spring.io/
*
*2、分析:
*  2.1 SpringApplication
* */