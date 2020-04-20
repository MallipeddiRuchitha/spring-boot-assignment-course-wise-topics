package com.ruchitha.coursewisetopicsdemo.service;

import com.ruchitha.coursewisetopicsdemo.dao.CourseRepository;
import com.ruchitha.coursewisetopicsdemo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository theCourseRepository) {
		courseRepository = theCourseRepository;
	}
	
	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}
	@Override
	public Optional<Course> findById(String courseName) {
		Optional<Course> course = courseRepository.findById(courseName);
		if (!course.isPresent()) {
			throw new RuntimeException("Course  not found - " + courseName);
		}


		return course;
	}

	@Override
	public Course saveNewCourse(Course course){
		String courseName=course.getCourse_name();

		Optional<Course> tempCourse = courseRepository.findById(courseName);
		if (tempCourse.isPresent()) {
			throw new RuntimeException("Course already exists - " +courseName );
		}



		return courseRepository.save(course);
	}
	@Override
	public Course updateCourse(Course course){
return courseRepository.save(course);



	}

	@Override
	public void deleteById(String courseName) {
		Optional<Course> course = courseRepository.findById(courseName);
		if (!course.isPresent()) {
			throw new RuntimeException("Course not found - " + courseName);
		}

		courseRepository.deleteById(courseName);


	}
	
}






