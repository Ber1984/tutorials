package com.erick.company;

import com.erick.company.config.RsaKeyProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperty.class)
public class JwtAuthenticationApp {
    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationApp.class);
    }
}