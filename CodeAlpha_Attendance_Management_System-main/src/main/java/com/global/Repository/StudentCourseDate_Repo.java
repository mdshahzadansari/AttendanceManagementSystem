package com.global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.Model.StudentCoursesId;
import com.global.Model.StudentCourses_Date;

import jakarta.transaction.Transactional;

@Repository
public interface StudentCourseDate_Repo extends JpaRepository<StudentCourses_Date, StudentCoursesId> {

	@Transactional
	void deleteByStudentId(Long studentId);

}
