package com.example.controller;

import com.example.model.School;
import com.example.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createSchool(@RequestBody School school) throws Exception {
        if(Objects.isNull(school)) {
            return new ResponseEntity("school object is null", HttpStatus.BAD_REQUEST);
        }
        return schoolService.saveOrUpdateSchool(school);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getSchool(@PathVariable Long id) throws Exception {
        return schoolService.getSchool(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity deleteSchool(@PathVariable Long id) throws Exception {
        return schoolService.deleteSchool(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity getAllSchools() throws Exception {
        return schoolService.getAllSchools();
    }
}
