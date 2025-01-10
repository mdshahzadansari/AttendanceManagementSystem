package com.global.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table

public class StudentCourses_Date {
	@EmbeddedId
	private StudentCoursesId id;

	@ManyToOne
	@MapsId("studentId")
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name = "course_id")
	private Courses course;

	@Column(name = "DateOfCourse")
	private LocalDate date;

	public StudentCourses_Date() {
		this.date = LocalDate.now();
	}

	public StudentCourses_Date(Student student, Courses course) {
		this.student = student;
		this.course = course;
		this.date = LocalDate.now();
		this.id = new StudentCoursesId(student.getId(), course.getCourseID());
	}

	// Getters and Setters
	public StudentCoursesId getId() {
		return id;
	}

	public void setId(StudentCoursesId id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}