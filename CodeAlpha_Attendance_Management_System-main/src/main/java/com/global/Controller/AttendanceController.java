package com.global.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.global.Model.StudentCourses_Date;
import com.global.Servece.CourseService;
import com.global.Servece.StudentService;

@Controller
public class AttendanceController {

	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;

	@GetMapping("/attendance")
	public String showRecordedPage(Model model) {
		model.addAttribute("students", studentService.GetAllStudents());
		model.addAttribute("courses", courseService.Get_all_Courses());
		model.addAttribute("studentCoursesDate", new StudentCourses_Date());
		return "RecordePage";
	}

	@PostMapping("/recordedStudentCourse")
	public String recordedStudentCourse(@RequestParam("studentName") String studentName,
			@RequestParam("courseName") String courseName) {
		studentService.recordStudentCourse(studentName, courseName);
		return "redirect:/student";
	}

}
