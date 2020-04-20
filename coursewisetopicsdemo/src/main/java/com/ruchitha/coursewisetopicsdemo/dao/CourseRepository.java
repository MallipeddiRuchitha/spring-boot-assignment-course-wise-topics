package com.ruchitha.coursewisetopicsdemo.dao;

import com.ruchitha.coursewisetopicsdemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, String> {

	
	
}
