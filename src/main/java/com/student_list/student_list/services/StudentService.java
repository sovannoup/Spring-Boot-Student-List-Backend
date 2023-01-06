package com.student_list.student_list.services;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_list.student_list.controllers.Request.CreateStudent;
import com.student_list.student_list.controllers.Response.Response;
import com.student_list.student_list.exception.ApiRequestException;
import com.student_list.student_list.models.Student;
import com.student_list.student_list.repo.Student.StudentRepo;

import lombok.Data;

@Service
@Data
public class StudentService {

    @Autowired
    private final StudentRepo _studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        _studentRepo = studentRepo;
    }

    public Response GetStudents() {
        List<Student> students = new LinkedList<>();
        try{
            students = _studentRepo.findAll();
        }catch(Exception err){
            throw(err);
        }
        return new Response(
                200,
                "Verify code already sent",
                students,
                LocalDateTime.now());
    }

    public Response GetStudentById(String id) {
        Optional<Student> students;
        try{
            students = _studentRepo.findById(id);
        }catch(Exception err){
            throw(err);
        }
        
        return new Response(
                200,
                "Verify code already sent",
                students,
                LocalDateTime.now());
    }

    public Response CreateStudent(Student student) {
        try {
            _studentRepo.save(student);
        } catch (Exception err) {
            throw (err);
        }
        return new Response(
                200,
                "Verify code already sent",
                null,
                LocalDateTime.now());
    }

    public Response EditStudentById(String id, CreateStudent req) {
        try {
            Optional<Student> student = _studentRepo.findById(id);
            if (student.isEmpty()) {
                throw new ApiRequestException("Student not found");
            }
            _studentRepo.EditStudentById(id, req.getName(), req.getAge());
        } catch (Exception err) {
            throw (err);
        }
        return new Response(
                200,
                "Verify code already sent",
                null,
                LocalDateTime.now());
    }

    public Response DeleteStudentById(String id) {
        Optional<Student> student = _studentRepo.findById(id);
        if (student.isEmpty()) {
            throw new ApiRequestException("Student not found");
        }
        _studentRepo.deleteById(Long.parseLong(id));
        return new Response(
                200,
                "Verify code already sent",
                null,
                LocalDateTime.now());
    }
}
