package com.example.controller;

import com.example.model.SportsClub;
import com.example.service.SportsClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/sportsClub")
public class SportsClubController {
    @Autowired
    private SportsClubService sportsClubService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createSportsClub(@RequestBody SportsClub sportsClub) throws Exception {
        if(Objects.isNull(sportsClub)) {
            return new ResponseEntity("sportsClub object is null", HttpStatus.BAD_REQUEST);
        }
        return sportsClubService.saveOrUpdateSportsClub(sportsClub);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getSportsClub(@PathVariable Long id) throws Exception {
        return sportsClubService.getSportsClub(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity deleteSportsClub(@PathVariable Long id) throws Exception {
        return sportsClubService.deleteSportsClub(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity getAllSportsClubs() throws Exception {
        return sportsClubService.getAllSportsClubs();
    }

    @RequestMapping(value = "/getAllSchoolsBySportsClubId/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllSchoolsBySportsClubId(@PathVariable Long id) throws Exception {
        return sportsClubService.getAllSchoolsBySportsClubId(id);
    }
}
