package com.testmateback.dTestmate.controller;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.properties") // 애플리케이션 설정 파일을 로드
public class DatabaseConfiguration {

    // HikariCP (Connection Pool) 설정을 위한 빈을 생성하는 메서드
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    // 데이터 소스(DataSource)를 설정하고 반환하는 메서드
    @Bean
    public DataSource dataSource() throws Exception {
        DataSource dataSource = new HikariDataSource(hikariConfig());

        // 데이터 소스 정보 출력 (디버깅 용도)
        System.out.println("DataSource Information: " + dataSource.toString());

        return dataSource;
    }
}

/*
 * 라이선스 정보:
 * 이 코드는 Spring Boot 애플리케이션의 데이터베이스 설정을 위한 구성 파일입니다.
 * HikariCP (Connection Pool)를 사용하여 데이터베이스 연결 관리를 합니다.
 * 라이선스 정보나 출처는 해당 라이브러리(HikariCP)의 라이선스를 따릅니다.
 * HikariCP 라이선스 정보: https://github.com/brettwooldridge/HikariCP#license
 */
