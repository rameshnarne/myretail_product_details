package com.myretail.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication (scanBasePackages = "com.myretail.products")
public class MyRetailProductDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailProductDetailsApplication.class, args);
	}
}
