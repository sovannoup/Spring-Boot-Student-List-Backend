package com.student_list.student_list.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "student")
@Table(name="student")
@Data
@NoArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    private String name;

    @NotNull
    private Integer age =0;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
}
