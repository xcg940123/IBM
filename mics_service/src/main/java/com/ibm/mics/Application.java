package com.ibm.mics;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = {"com.ibm.mics.**"})
@MapperScan("com.ibm.mics.sql.mapper.**")
@PropertySources({ @PropertySource(value = "classpath:micsApplication.properties", ignoreResourceNotFound = true)})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}