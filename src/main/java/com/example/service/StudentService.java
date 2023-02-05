package com.example.service;

import com.example.model.Student;
import com.example.model.StudentDto;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    public ResponseEntity saveOrUpdateStudent(StudentDto student) throws Exception;
    public ResponseEntity getStudent(Long id) throws Exception;
    public ResponseEntity deleteStudent(Long id) throws Exception;
    public ResponseEntity getAllStudents() throws Exception;
    public ResponseEntity getStudentsBySchoolId(Long id) throws Exception;
}
