package com.example.dao;

import com.example.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends CrudRepository<Student, Long> {
    @Query("SELECT stu FROM Student stu JOIN stu.school scl where scl.id=?1")
    List<Student> findStudentsBySchoolId(@Param("id") Long id);
}
