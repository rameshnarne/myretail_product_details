package com.myretail.products;

import com.myretail.products.helper.CommonHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication (scanBasePackages = "com.myretail.products")
@EnableAutoConfiguration (exclude = {ErrorMvcAutoConfiguration.class})
public class MyRetailProductDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailProductDetailsApplication.class, args);
	}

	@Bean
	public CommonHelper commonHelper() {
		return new CommonHelper();
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

}
