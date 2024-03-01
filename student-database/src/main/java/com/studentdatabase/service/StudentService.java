package com.studentdatabase.service;

import java.util.List;

import com.studentdatabase.entity.Student;

public interface StudentService {

	Student saveStudent(Student student);
	List<Student> getAllStudents();
	int maxScore();
	int minScore();
	String maxLetter();
	String minLetter();
	String findGrade(Long PID);
	String findFullName(Long PID);
	void change(Long PID, String gradeCharacter);
	double averageScore();
	String averageLetter();
	double medianScore();
	String medianLetter();
	
}
