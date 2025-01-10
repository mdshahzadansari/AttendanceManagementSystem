package com.global.Model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable

public class StudentCoursesId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long studentId;
	private Long courseId;

	public StudentCoursesId() {
	}

	public StudentCoursesId(Long studentId, Long courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		StudentCoursesId that = (StudentCoursesId) o;
		return Objects.equals(studentId, that.studentId) && Objects.equals(courseId, that.courseId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentId, courseId);
	}
}