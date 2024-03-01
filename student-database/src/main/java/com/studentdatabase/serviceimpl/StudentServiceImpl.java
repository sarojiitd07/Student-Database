package com.studentdatabase.serviceimpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentdatabase.entity.Grade;
import com.studentdatabase.entity.Student;
import com.studentdatabase.repo.GradeRepo;
import com.studentdatabase.repo.StudentRepository;
import com.studentdatabase.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private GradeRepo gradeRepo;

	public static String calculateGrade(int marks) {
		if (marks >= 90) {
			return "A";
		} else if (marks >= 85) {
			return "A-";
		} else if (marks >= 80) {
			return "B+";
		} else if (marks >= 75) {
			return "B";
		} else if (marks >= 70) {
			return "B-";
		} else if (marks >= 65) {
			return "C+";
		} else if (marks >= 60) {
			return "C";
		} else if (marks >= 55) {
			return "C-";
		} else if (marks >= 50) {
			return "D";
		} else {
			return "F";
		}
	}

	public int maxScore() {
		int max = Integer.MIN_VALUE;
		List<Student> listOfStudents = studentRepository.findAll();
		for (int i = 0; i < listOfStudents.size(); i++) {
			if (max < listOfStudents.get(i).getGradeScore().getScore()) {
				max = listOfStudents.get(i).getGradeScore().getScore();
			}
		}
		return max;
	}

	public int minScore() {
		int min = Integer.MAX_VALUE;
		List<Student> listOfStudents = studentRepository.findAll();
		for (int i = 0; i < listOfStudents.size(); i++) {
			if (min > listOfStudents.get(i).getGradeScore().getScore()) {
				min = listOfStudents.get(i).getGradeScore().getScore();
			}
		}
		return min;
	}

	public String maxLetter() {
		int max = Integer.MIN_VALUE;
		List<Student> listOfStudents = studentRepository.findAll();
		for (int i = 0; i < listOfStudents.size(); i++) {
			if (max < listOfStudents.get(i).getGradeScore().getScore()) {
				max = listOfStudents.get(i).getGradeScore().getScore();
			}
		}
		return calculateGrade(max);
	}

	public String minLetter() {
		int min = Integer.MAX_VALUE;
		List<Student> listOfStudents = studentRepository.findAll();
		for (int i = 0; i < listOfStudents.size(); i++) {
			if (min > listOfStudents.get(i).getGradeScore().getScore()) {
				min = listOfStudents.get(i).getGradeScore().getScore();
			}
		}
		return calculateGrade(min);
	}

	public String findGrade(Long PID) {
		List<Student> listOfStudents = studentRepository.findAll();
		for (int i = 0; i < listOfStudents.size(); i++) {
			if (PID.equals(listOfStudents.get(i).getPID())) {
				return listOfStudents.get(i).getGradeScore().getGrade();
			}
		}
		return "";
	}

	public String findFullName(Long PID) {
		List<Student> listOfStudents = studentRepository.findAll();
		for (int i = 0; i < listOfStudents.size(); i++) {
			if (PID.equals(listOfStudents.get(i).getPID())) {
				return listOfStudents.get(i).getFirstName() + " " + listOfStudents.get(i).getLastName();
			}
		}
		return "";
	}

	public void change(Long PID, String gradeCharacter) {
		int index = 0;
		List<Student> listOfStudents = studentRepository.findAll();
		for (int i = 0; i < listOfStudents.size(); i++) {
			if (PID.equals(listOfStudents.get(i).getPID())) {
				listOfStudents.get(i).getGradeScore().setGrade(gradeCharacter);
				studentRepository.save(listOfStudents.get(i));
				index = i;
			}
		}
//		System.out.println(listOfStudents.get(index));
		System.out.println("Changed successfully");
	}

	public double averageScore() {
		double totalMarks = 0;
		List<Student> listOfStudents = studentRepository.findAll();
		for (int i = 0; i < listOfStudents.size(); i++) {
			totalMarks += listOfStudents.get(i).getGradeScore().getScore();
		}
		double avgScore = (totalMarks / listOfStudents.size());
		return avgScore;
	}

	public String averageLetter() {
		double totalMarks = 0;
		List<Student> listOfStudents = studentRepository.findAll();
		for (int i = 0; i < listOfStudents.size(); i++) {
			totalMarks += listOfStudents.get(i).getGradeScore().getScore();
		}
		double avgScore = (totalMarks / listOfStudents.size());
		String avgLetter = calculateGrade((int) Math.ceil(avgScore));
		return avgLetter;
	}

	public double medianScore() {
		List<Student> listOfStudents = studentRepository.findAll();
		listOfStudents.sort(Comparator.comparingInt(student->student.getGradeScore().getScore()));
		int length = listOfStudents.size();

		if (length % 2 == 0) {
			// If the number of scores is even, average the two middle values
			int mid1 = length / 2 - 1;
			int mid2 = length / 2;
			return (listOfStudents.get(mid1).getGradeScore().getScore()
					+ listOfStudents.get(mid2).getGradeScore().getScore()) / 2.0;
		} else {
			// If the number of scores is odd, take the middle value
			int mid = length / 2;
			return listOfStudents.get(mid).getGradeScore().getScore();
		}
	}

	public String medianLetter() {
		List<Student> listOfStudents = studentRepository.findAll();
		listOfStudents.sort(Comparator.comparingInt(student->student.getGradeScore().getScore()));
		int medianScore = 0;
		int length = listOfStudents.size();

		if (length % 2 == 0) {
			// If the number of scores is even, average the two middle values
			int mid1 = length / 2 - 1;
			int mid2 = length / 2;
			medianScore = (int) ((listOfStudents.get(mid1).getGradeScore().getScore()
					+ listOfStudents.get(mid2).getGradeScore().getScore()) / 2.0);
		} else {
			// If the number of scores is odd, take the middle value
			int mid = length / 2;
			medianScore = listOfStudents.get(mid).getGradeScore().getScore();
		}
		String medianString = calculateGrade(medianScore);
		return medianString;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		Grade grade = Grade.builder().PID(student.getPID()).grade(calculateGrade(student.getGradeScore().getScore()))
				.score(student.getGradeScore().getScore()).build();
		gradeRepo.save(grade);
		System.out.println(grade);
		student.setGradeScore(grade);
		return studentRepository.save(student);
	}
}
