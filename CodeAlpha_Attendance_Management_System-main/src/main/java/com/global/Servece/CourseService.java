package com.global.Servece;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.Model.Courses;
import com.global.Repository.CoursesRepo;

@Service
public class CourseService {

	@Autowired
	CoursesRepo coursesRepo;

	public List<Courses> Get_all_Courses() {
		return coursesRepo.findAll();
	}

	public Courses findByIDD(Long id) {
		return coursesRepo.findById(id).get();
	}

	public void add_New_Course(Courses courses) {
		coursesRepo.save(courses);
	}

	public void Delete_Course(Long id) {
		coursesRepo.deleteById(id);
	}

	public void Update_Course(Courses newCourse) {

		Courses existCourse = new Courses();
		existCourse.setCourseID(newCourse.getCourseID());
		existCourse.setCourseName(newCourse.getCourseName());
		existCourse.setInstructor(newCourse.getInstructor());
		existCourse.setCourseLevel(newCourse.getCourseLevel());

		coursesRepo.save(existCourse);
	}

}
