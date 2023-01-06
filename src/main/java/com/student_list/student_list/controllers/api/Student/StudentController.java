package com.student_list.student_list.controllers.api.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.student_list.student_list.controllers.Request.CreateStudent;
import com.student_list.student_list.controllers.Response.Response;
import com.student_list.student_list.exception.ApiRequestException;
import com.student_list.student_list.models.Student;
import com.student_list.student_list.services.StudentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@AllArgsConstructor
// @SecurityRequirement(name = "student")
@Slf4j
@RequestMapping("/api/student/")
public class StudentController 
{
    @Autowired
    private final StudentService _studentService;

    @GetMapping(path = "getstudents")
    public ResponseEntity<Response> GetStudents() {
        return ResponseEntity.ok().body(_studentService.GetStudents());
    }

    @GetMapping(path = "getstudentbyid")
    public ResponseEntity<Response> GetStudentById(@RequestParam("id") String id) {
        if(id == null){
            throw new ApiRequestException("ID is required");
        }
        return ResponseEntity.ok().body(_studentService.GetStudentById(id));
    }

    @PostMapping(path = "createstudent")
    public ResponseEntity<Response> CreateStudent(@Valid @RequestBody CreateStudent req) {
        Student student = new Student(req.getName(), req.getAge());
        return ResponseEntity.ok().body(_studentService.CreateStudent(student));
    }

    @PutMapping(path = "editstudentbyid")
    public ResponseEntity<Response> EditStudentById(@RequestParam("id") String id, @Valid @RequestBody CreateStudent req) {
        return ResponseEntity.ok().body(_studentService.EditStudentById(id, req));
    }

    @DeleteMapping(path = "deletestudentbyid")
    public ResponseEntity<Response> DeleteStudentById(@RequestParam("id") String id) {
        return ResponseEntity.ok().body(_studentService.DeleteStudentById(id));
    }
}
