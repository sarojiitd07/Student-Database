package com.studentdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentdatabase.entity.Student;
import com.studentdatabase.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentServiceImpl;

	@GetMapping("/maxScore")
	public int maxScore( ) {
		return studentServiceImpl.maxScore();
	}
	
	@GetMapping("/minScore")
	public int minScore() {
		return studentServiceImpl.minScore();
	}
	
	@GetMapping("/maxLetter")
	public String maxLetter() {
		return studentServiceImpl.maxLetter();
	}
	
	@GetMapping("/minLetter")
	public String minLetter() {
		return studentServiceImpl.minLetter();
	}
	
	@GetMapping("/findGrade/{PID}")
	public String findGrade(@PathVariable Long PID) {
		return studentServiceImpl.findGrade(PID);
	}
	
	@GetMapping("/findFullName/{PID}")
	public String findFullName(@PathVariable Long PID) {
		return studentServiceImpl.findFullName(PID);
	}
	
	@GetMapping("/change/{PID}/{gradeCharacter}")
	public void change(@PathVariable Long PID, @PathVariable String gradeCharacter) {
		studentServiceImpl.change(PID, gradeCharacter);
	}
	
	@GetMapping("/avgScore")
	public double avgScore() {
		return studentServiceImpl.averageScore();
	}
	
	@GetMapping("/avgLetter")
	public String avgLetter() {
		return studentServiceImpl.averageLetter();
	}
	
	@GetMapping("medianScore")
	public double medianScore() {
		return studentServiceImpl.medianScore();
	}
	
	@GetMapping("/medianLetter")
	public String medianLetter() {
		return studentServiceImpl.medianLetter();
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<>(studentServiceImpl.getAllStudents(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student saveStudent = studentServiceImpl.saveStudent(student);
		return new ResponseEntity<Student>(saveStudent,HttpStatus.CREATED);
	}
}
