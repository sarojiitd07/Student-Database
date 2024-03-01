package com.studentdatabase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentdatabase.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
