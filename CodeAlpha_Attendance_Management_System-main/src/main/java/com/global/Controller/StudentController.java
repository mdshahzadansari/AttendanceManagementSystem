package com.global.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.global.Model.Student;
import com.global.Servece.CourseService;
import com.global.Servece.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;

	@GetMapping("/student")
	public String Show_Students(Model model) {
		model.addAttribute("allStudent", studentService.GetAllStudents());
		return "Students_Page";
	}

	@GetMapping("/student/add")
	public String Open_AddStudentPage(Model model) {
		model.addAttribute("newStudent", new Student());
		model.addAttribute("courseList", courseService.Get_all_Courses());
		return "Add_NewStudent";
	}

	@PostMapping("/student/addNewStudent")
	public String AddedNewStudent(@ModelAttribute("student") Student student) {

		studentService.AddStudents(student);

		return "redirect:/student";
	}

	@GetMapping("/student/deleteStd/{STDid}")
	public String DeleteStudent(@PathVariable Long STDid) {
		studentService.DeleteStudent(STDid);
		return "redirect:/student";
	}

	@GetMapping("/student/updateStd/{id}")
	public String UpdateStudent(@PathVariable Long id, Model model) {
		model.addAttribute("updateStudent", studentService.FindStudentById(id));
		return "UpdateStudent";
	}

	@PostMapping("/student/updateStd/{id}")
	public String UpdatedStudent(@PathVariable Long id, @ModelAttribute("updateStudent") Student student) {

		studentService.UpdateStudent(student);
		return "redirect:/student";

	}

}
