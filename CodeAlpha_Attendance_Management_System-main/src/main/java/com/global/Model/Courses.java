package com.global.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CourseID;
	private String courseName;
	private int CourseLevel;
	private String instructor;
	@OneToMany(mappedBy = "course")
	private List<StudentCourses_Date> studentsInCourses;

	public Courses() {
	}

	public Courses(Long courseID, String courseName, int courseLevel, String instructor) {
		CourseID = courseID;
		this.courseName = courseName;
		CourseLevel = courseLevel;
		this.instructor = instructor;
	}

	public int getCourseLevel() {
		return CourseLevel;
	}

	public void setCourseLevel(int courseLevel) {
		CourseLevel = courseLevel;
	}

	public void setStudentsInCourses(List<StudentCourses_Date> studentsInCourses) {
		this.studentsInCourses = studentsInCourses;
	}

	public Long getCourseID() {
		return CourseID;
	}

	public void setCourseID(Long courseID) {
		CourseID = courseID;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public List<StudentCourses_Date> getStudentsInCourses() {
		return studentsInCourses;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
