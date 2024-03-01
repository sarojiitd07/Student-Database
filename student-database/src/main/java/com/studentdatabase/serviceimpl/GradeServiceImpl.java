package com.studentdatabase.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentdatabase.entity.Grade;
import com.studentdatabase.repo.GradeRepo;
import com.studentdatabase.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService{
	
	@Autowired
	private GradeRepo gradeRepo;

	@Override
	public Grade saveGrade(Grade grade) {
		return gradeRepo.save(grade);
	}

}
