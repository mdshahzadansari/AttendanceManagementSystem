package com.global.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.global.Model.Courses;
import com.global.Servece.CourseService;

@Controller
public class CoursesController {

	@Autowired
	CourseService courseService;

	@GetMapping("/")
	public String GetStarted() {
		return "StartPage";
	}

	@GetMapping("/course")
	public String Open_Courses(Model model) {
		model.addAttribute("allCourse", courseService.Get_all_Courses());
		return "Courses_Page";
	}

	@GetMapping("/courses/add")
	public String add_Course(Model model) {
		model.addAttribute("newCourse", new Courses());
		return "add_NewCourse";
	}

	@PostMapping("/added_course")
	public String CoursesPage(@ModelAttribute("newCourse") Courses newCourse) {
		courseService.add_New_Course(newCourse);
		return "redirect:/course";
	}

	@GetMapping("/courses/delete/{CourseID}")
	public String DeleteCourse(@PathVariable Long CourseID) {
		courseService.Delete_Course(CourseID);
		return "redirect:/course";
	}

	@GetMapping("/courses/update/{CourseID}")
	public String OpenForUpdateCourse(@PathVariable Long CourseID, Model model) {
		model.addAttribute("editCourse", courseService.findByIDD(CourseID));
		return "upateCourse";
	}

	@PostMapping("/courses/update/{CourseID}")
	public String UpdateCourse(@PathVariable Long CourseID, @ModelAttribute("nCourse") Courses nCourse) {
		courseService.Update_Course(nCourse);

		return "redirect:/course";
	}

}
