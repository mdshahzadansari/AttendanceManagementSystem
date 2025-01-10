package com.global.Model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Student Code", nullable = false, unique = true)
	private int StudentCode;
	private String studentName;
	private String studentEmail;
	private int level;
	@ManyToOne
	private Courses course;

	@OneToMany(mappedBy = "student")
	private List<StudentCourses_Date> studentCourses;


	public Student() {
	}

	public Student(Long id, int studentCode, String studentName, String studentEmail, int level, Courses course,
			List<StudentCourses_Date> studentCourses) {
		this.id = id;
		StudentCode = studentCode;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.level = level;
		this.course = course;
		this.studentCourses = studentCourses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void addCourse(StudentCourses_Date course) {
		this.studentCourses.add(course);
	}

	public void removeCourse(StudentCourses_Date course) {
		studentCourses.remove(course);
		course.setStudent(null);
	}

	public List<StudentCourses_Date> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourses_Date> studentCourses) {
		this.studentCourses = studentCourses;
	}

	public int getStudentCode() {
		return StudentCode;
	}

	public void setStudentCode(int studentCode) {
		StudentCode = studentCode;
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	public String getCourseName() {
		if (studentCourses != null && !studentCourses.isEmpty()) {
			StudentCourses_Date firstCourse = studentCourses.get(0);
			if (firstCourse != null && firstCourse.getCourse() != null) {
				return firstCourse.getCourse().getCourseName();
			}
		}
		return "Not added course yet";
	}

}
