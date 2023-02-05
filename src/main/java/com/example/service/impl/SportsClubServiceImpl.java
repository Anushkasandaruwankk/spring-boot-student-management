package com.example.service.impl;

import com.example.dao.SportsClubDao;
import com.example.model.School;
import com.example.model.SportsClub;
import com.example.model.Student;
import com.example.service.SportsClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SportsClubServiceImpl implements SportsClubService {

    @Autowired
    private SportsClubDao sportsClubDao;

    @Override
    public ResponseEntity saveOrUpdateSportsClub(SportsClub sportsClub) throws Exception {
        return new ResponseEntity(sportsClubDao.save(sportsClub), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity getSportsClub(Long id) throws Exception {
        Optional sportsClub = sportsClubDao.findById(id);
        if(!sportsClub.isPresent()) {
            return new ResponseEntity("No data Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(sportsClub.get(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity deleteSportsClub(Long id) throws Exception {
        sportsClubDao.deleteById(id);
        return new ResponseEntity(sportsClubDao.findAll(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity getAllSportsClubs() throws Exception {
        List<SportsClub> sportsClubs = (List<SportsClub>) sportsClubDao.findAll();
        return new ResponseEntity(sportsClubs, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity getAllSchoolsBySportsClubId(Long id) throws Exception {
        List<Student> students = (List<Student>) sportsClubDao.getAllStudentsBySportsClubId(id);
        List<School> schools = students.stream()
                .map(Student::getSchool).distinct()
                .collect(Collectors.toList());
        return new ResponseEntity(schools, HttpStatus.ACCEPTED);
    }
}
