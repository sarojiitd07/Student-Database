package com.studentdatabase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentdatabase.entity.Grade;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Long>{

}
