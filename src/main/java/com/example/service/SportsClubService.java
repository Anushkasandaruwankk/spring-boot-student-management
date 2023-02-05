package com.example.service;

import com.example.model.SportsClub;
import org.springframework.http.ResponseEntity;

public interface SportsClubService {
    public ResponseEntity saveOrUpdateSportsClub(SportsClub sportsClub) throws Exception;
    public ResponseEntity getSportsClub(Long id) throws Exception;
    public ResponseEntity deleteSportsClub(Long id) throws Exception;
    public ResponseEntity getAllSportsClubs() throws Exception;
    public ResponseEntity getAllSchoolsBySportsClubId(Long id) throws Exception;
}
