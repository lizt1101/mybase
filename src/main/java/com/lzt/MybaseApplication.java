package com.lzt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.lzt.dao")
@ComponentScan("com.lzt")
public class MybaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybaseApplication.class, args);
	}
}
