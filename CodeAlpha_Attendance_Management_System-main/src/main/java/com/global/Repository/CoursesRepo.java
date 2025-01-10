package com.global.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.global.Model.Courses;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, Long> {
	List<Courses> findAll();
	Courses findByCourseName(String CourseName);
}
