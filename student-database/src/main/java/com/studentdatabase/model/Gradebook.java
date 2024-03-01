package com.studentdatabase.model;

import java.util.List;

import com.studentdatabase.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Gradebook {
	private List<Student> listOfStudents;
}