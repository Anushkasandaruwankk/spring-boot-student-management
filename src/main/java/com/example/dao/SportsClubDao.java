package com.example.dao;

import com.example.model.School;
import com.example.model.SportsClub;
import com.example.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SportsClubDao extends CrudRepository<SportsClub, Long> {

    @Query("SELECT st FROM SportsClub sp JOIN sp.students st where sp.id=?1")
    List<Student> getAllStudentsBySportsClubId(Long id);
}
