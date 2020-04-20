package com.ruchitha.coursewisetopicsdemo.controller;

import com.ruchitha.coursewisetopicsdemo.entity.Course;
import com.ruchitha.coursewisetopicsdemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/courses")
public class CourseController {

	private CourseService courseService;
	@Autowired
	public CourseController(CourseService theCourseService) {
	courseService = theCourseService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		

		List<Course> theCourses = courseService.findAll();
		
		// add to the spring model
		theModel.addAttribute("courses", theCourses);
		
		return "courses/list-courses";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {


		Course  course = new Course();

		// create model attribute to bind form data
		model.addAttribute("course", course);

		return "courses/course-form";
	}
	@PostMapping("/saveNewCourse")
	public String saveCourse( @ModelAttribute("course") Course course) {

		courseService.saveNewCourse(course);


		return "redirect:/courses/list";
	}
	@PostMapping("/updateCourse")
	public String updateCourse( @ModelAttribute("course") Course course) {

		courseService.updateCourse(course);


		return "redirect:/courses/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("course_name") String name,
									Model model) {



		Optional<Course> course=courseService.findById(name);


		model.addAttribute("course", course);


		return "courses/course-update-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("course_name") String courseName) {


		courseService.deleteById(courseName);


		return "redirect:/courses/list";

	}
}


















