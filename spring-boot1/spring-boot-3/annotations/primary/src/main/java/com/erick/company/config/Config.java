package com.erick.company.config;

import com.erick.company.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages="com.erick.company") //I need to add this annotation to allow @primary behavior with components
public class Config {

    /*
   In some cases, we need to register more than one bean of the same type.
    */
    @Bean
    public Employee jhonEmployee() {
        return new Employee("Jhon");
    }

    @Bean
    @Primary
    public Employee tonyEmployee() {
        return new Employee("Tony");
    }

}
