package com.example.dao;

import com.example.model.School;
import org.springframework.data.repository.CrudRepository;

public interface SchoolDao extends CrudRepository<School, Long> {

}
