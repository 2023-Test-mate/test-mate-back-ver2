package com.testmateback;

import jakarta.persistence.Enumerated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = "com.testmateback.dTestmate") // 패키지 이름을 알맞게 변경
public class TestMateBackApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestMateBackApplication.class, args);
	}

}

