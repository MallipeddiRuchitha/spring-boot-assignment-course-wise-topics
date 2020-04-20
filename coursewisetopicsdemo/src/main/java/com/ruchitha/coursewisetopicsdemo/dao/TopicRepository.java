package com.ruchitha.coursewisetopicsdemo.dao;

import com.ruchitha.coursewisetopicsdemo.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
	
	
	 @Query("SELECT t FROM Topic t  WHERE t.course.course_name=(:course_name)")
List<Topic> findByCourseName(@Param("course_name") String course_name);

}
