package com.student_list.student_list;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.student_list.student_list.models.Student;
import com.student_list.student_list.repo.Student.StudentRepo;
import com.student_list.student_list.services.StudentService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication

@OpenAPIDefinition(info = @Info(title = "Student List", version = "1.0", description = "listing students"))
@SecurityScheme(name = "StudentList", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)

public class StudentListApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentListApplication.class, args);
	}

}
