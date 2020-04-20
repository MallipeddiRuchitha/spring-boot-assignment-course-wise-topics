package com.ruchitha.coursewisetopicsdemo.service;

import com.ruchitha.coursewisetopicsdemo.entity.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicService {

	 List<Topic> findTopicsByCourse(String course_name);


	Topic saveTopic(Topic topic);

	Optional<Topic> findById(int id);

	//Optional<Topic> findByTopicAndCourse(String topic,String course);
	void  deleteById(int id);


}
