package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Service.StudentService;

@SpringBootApplication
public class StudentManagingApplication {
//public class StudentManagingApplication implements CommandLineRunner {
	
	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagingApplication.class, args);
	}
	
//	public void run(String[] args) throws Exception {
//		 
//		studentService.save(
//				new Student(1L,"11223344","Fatma",80));
//		studentService.save(
//				new Student(2L,"11223344","Mariem",90));
//		studentService.save(
//				new Student(3L,"11223344","Emna",100));
//		
//		
//	}

}
