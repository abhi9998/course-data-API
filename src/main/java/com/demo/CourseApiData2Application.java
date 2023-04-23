package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@SpringBootApplication
@EnableJpaRepositories(basePackages="com.demo")
@OpenAPIDefinition(info=@Info(title="Abhi APIS"))
public class CourseApiData2Application {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiData2Application.class, args);
	}

}
