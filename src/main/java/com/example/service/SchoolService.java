package com.example.service;

import com.example.model.School;
import org.springframework.http.ResponseEntity;

public interface SchoolService {
    public ResponseEntity saveOrUpdateSchool(School school) throws Exception;
    public ResponseEntity getSchool(Long id) throws Exception;
    public ResponseEntity deleteSchool(Long id) throws Exception;
    public ResponseEntity getAllSchools() throws Exception;
}
