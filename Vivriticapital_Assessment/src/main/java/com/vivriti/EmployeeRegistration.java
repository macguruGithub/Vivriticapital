package com.vivriti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class EmployeeRegistration implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeRegistration.class);


    }

    //Assignment 2 : To find the average of a list of integers
    public void run(String... args){
        List<Integer> list = List.of(1,2,4,5);
        Integer value = list.stream().reduce(0,(prev,cur)->prev+cur);
        System.out.println("assign second ans ==> "+value/list.size());
    }
}
