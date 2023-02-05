package com.example.service.impl;

import com.example.dao.SchoolDao;
import com.example.model.School;
import com.example.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolDao schoolDao;

    @Override
    public ResponseEntity saveOrUpdateSchool(School school) throws Exception {
        return new ResponseEntity(schoolDao.save(school), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity getSchool(Long id) throws Exception {
        Optional school = schoolDao.findById(id);
        if(!school.isPresent()) {
            return new ResponseEntity("No data Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(school.get(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity deleteSchool(Long id) throws Exception {
        schoolDao.deleteById(id);
        return new ResponseEntity(schoolDao.findAll(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity getAllSchools() throws Exception {
        List<School> schools = (List<School>) schoolDao.findAll();
        return new ResponseEntity(schools, HttpStatus.ACCEPTED);
    }


}
