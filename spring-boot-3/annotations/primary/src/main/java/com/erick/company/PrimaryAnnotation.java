package com.erick.company;

import com.erick.company.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class PrimaryAnnotation implements CommandLineRunner {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private Employee employee;


    public static void main(String[] args) {
        SpringApplication.run(PrimaryAnnotation.class);
    }

    @Override
    public void run(String... args) {
        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
        }
    }
}