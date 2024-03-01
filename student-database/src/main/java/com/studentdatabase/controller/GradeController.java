package com.studentdatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentdatabase.entity.Grade;
import com.studentdatabase.service.GradeService;

@RestController
@RequestMapping("/grade")
public class GradeController {
	
	@Autowired
	private GradeService gradeService;
	
	@PostMapping
	public ResponseEntity<Grade> createGrade(@RequestBody Grade grade){
		Grade saveGrade = gradeService.saveGrade(grade);
		return new ResponseEntity<Grade>(saveGrade,HttpStatus.CREATED);
	}
	
}
