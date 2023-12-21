package com.fashionlike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fashionlike")
public class FashionLikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FashionLikeApplication.class, args);
	}

}
