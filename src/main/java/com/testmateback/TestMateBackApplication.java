package com.testmateback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = {"com.testmateback.domain", "com.testmateback.global"})
public class TestMateBackApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestMateBackApplication.class, args);
	}

}

