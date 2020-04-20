package com.ruchitha.coursewisetopicsdemo.service;

import com.ruchitha.coursewisetopicsdemo.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

	 List<Course> findAll();
	Course saveNewCourse(Course course);
	Course updateCourse(Course course);

	Optional<Course> findById(String id);
	void deleteById(String id);



}
