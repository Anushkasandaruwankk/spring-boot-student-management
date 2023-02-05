package com.example.controller;

import com.example.model.Student;
import com.example.model.StudentDto;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createStudent(@RequestBody StudentDto student) throws Exception {
        if(Objects.isNull(student)) {
            return new ResponseEntity("student object is null", HttpStatus.BAD_REQUEST);
        }
        return studentService.saveOrUpdateStudent(student);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getStudent(@PathVariable Long id) throws Exception {
        return studentService.getStudent(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity deleteStudent(@PathVariable Long id) throws Exception {
        return studentService.deleteStudent(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity getAllStudents() throws Exception {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/getStudentsBySchoolId/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllStudents(@PathVariable Long id) throws Exception {
        return studentService.getStudentsBySchoolId(id);
    }
}
