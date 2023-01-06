package com.student_list.student_list.repo.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student_list.student_list.models.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepo extends JpaRepository< Student, Long>{
    Optional<Student> findById(String id);

    @Transactional
    @Modifying
    @Query("UPDATE student s " +
            "SET s.name = ?2, s.age = ?3 " +
            "WHERE s.id = ?1")
    int EditStudentById(String id, String name, int age);
}
