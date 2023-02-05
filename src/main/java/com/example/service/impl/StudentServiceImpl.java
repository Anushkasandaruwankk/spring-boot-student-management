package com.example.service.impl;

import com.example.dao.SchoolDao;
import com.example.dao.StudentDao;
import com.example.model.School;
import com.example.model.Student;
import com.example.model.StudentDto;
import com.example.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private SchoolDao schoolDao;

    @Override
    public ResponseEntity saveOrUpdateStudent(StudentDto studentDto) throws Exception {
        Student student = new Student();
        if(!Objects.isNull(studentDto.getSchool())) {
            School school;
            if(!Objects.isNull(studentDto.getSchool().getId())) {
                school = schoolDao.findById(studentDto.getSchool().getId()).get();
            } else {
                school = schoolDao.save(studentDto.getSchool());
            }
            if(!Objects.isNull(school)) {
                studentDto.setSchool(school);
            }
        } else {
            return new ResponseEntity("School is Required", HttpStatus.BAD_REQUEST);
        }
        if(!Objects.isNull(studentDto.getImagePath())) {
            student.setProfileImage(this.getImageToBase64(studentDto.getImagePath()));
        }
        if(studentDto.getId() != null) {
            student.setId(studentDto.getId());
        }
        if(studentDto.getSchool() != null) {
            student.setSchool(studentDto.getSchool());
        }
        if(studentDto.getAddress() != null) {
            student.setAddress(studentDto.getAddress());
        }
        if(studentDto.getName() != null) {
            student.setName(studentDto.getName());
        }
        if(studentDto.getSportsClubs() != null) {
            student.setSportsClubs(studentDto.getSportsClubs());
        }
        student.setAge(studentDto.getAge());
        return new ResponseEntity(studentDao.save(student), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity getStudent(Long id) throws Exception {
        Optional student = studentDao.findById(id);
        if(!student.isPresent()) {
            return new ResponseEntity("No data Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(student.get(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity deleteStudent(Long id) throws Exception {
        studentDao.deleteById(id);
        return new ResponseEntity(studentDao.findAll(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity getAllStudents() throws Exception {
        List<Student> students = (List<Student>) studentDao.findAll();
        if(CollectionUtils.isEmpty(students)) {
            return new ResponseEntity("No data Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(students, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity getStudentsBySchoolId(Long id) throws Exception {
        List<Student> students = (List<Student>) studentDao.findStudentsBySchoolId(id);
        if(CollectionUtils.isEmpty(students)) {
            return new ResponseEntity("No data Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(students, HttpStatus.ACCEPTED);
    }

    private byte[] getImageToBase64(String imagePath) throws Exception {
        Path filePath = Paths.get(imagePath);
        if (!Files.exists(filePath)) {
            throw new Exception("File doesn't exist.");
        }
        byte[] bytes = Files.readAllBytes(filePath);

        return Base64.getEncoder().encode(bytes);
    }
}
