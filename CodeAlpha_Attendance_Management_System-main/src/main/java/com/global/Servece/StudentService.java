package com.global.Servece;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.Model.Courses;
import com.global.Model.Student;
import com.global.Model.StudentCourses_Date;
import com.global.Repository.CoursesRepo;
import com.global.Repository.StudentCourseDate_Repo;
import com.global.Repository.StudentRepo;
import jakarta.transaction.Transactional;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;
	@Autowired
	CoursesRepo coursesRepo;
	@Autowired
	StudentCourseDate_Repo studentCourseDate_Repo;

	public List<Student> GetAllStudents() {
		List<Student> students = studentRepo.findAll();
		for (Student student : students) {
			String courseName = student.getCourseName();
			System.out.println("Student: " + student.getStudentName() + ", Course: " + courseName);
		}
		return students;
	}

	public Student FindStudentById(Long id) {
		return studentRepo.findById(id).get();
	}

	public void AddStudents(Student std) {
		studentRepo.save(std);
	}

	@Transactional
	public void DeleteStudent(Long id) {
		studentCourseDate_Repo.deleteByStudentId(id);
		studentRepo.deleteById(id);

	}

	@Transactional
	public void UpdateStudent(Student student) {

		Student existingStudent = new Student();
		existingStudent.setId(student.getId());
		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setStudentCode(student.getStudentCode());
		existingStudent.setStudentEmail(student.getStudentEmail());
		existingStudent.setLevel(student.getLevel());

		studentRepo.save(existingStudent);
	}

	@Transactional
	public void recordStudentCourse(String studentName, String courseName) {
		Student student = studentRepo.findByStudentName(studentName)
				.orElseThrow(() -> new IllegalArgumentException("Student not found"));

		Courses course = coursesRepo.findByCourseName(courseName);

		StudentCourses_Date studentCourseDate = new StudentCourses_Date(student, course);
		if (!student.getStudentCourses().contains(studentCourseDate)) {
			student.getStudentCourses().add(studentCourseDate);
		}
		if (!course.getStudentsInCourses().contains(studentCourseDate)) {
			course.getStudentsInCourses().add(studentCourseDate);
		}

		studentCourseDate_Repo.save(studentCourseDate);
	}

}
