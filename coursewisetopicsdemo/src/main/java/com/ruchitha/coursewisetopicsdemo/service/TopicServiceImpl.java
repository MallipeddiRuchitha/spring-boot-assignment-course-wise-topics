package com.ruchitha.coursewisetopicsdemo.service;

import com.ruchitha.coursewisetopicsdemo.dao.TopicRepository;
import com.ruchitha.coursewisetopicsdemo.entity.Course;
import com.ruchitha.coursewisetopicsdemo.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

	private TopicRepository topicRepository;
	
	@Autowired
	public TopicServiceImpl(TopicRepository theTopicRepository) {
		topicRepository = theTopicRepository;
	}
	
	
@Override
public Optional<Topic> findById(int id){
	Optional<Topic> topic = topicRepository.findById(id);
	if (!topic.isPresent()) {
		throw new RuntimeException("Topic id not found - " + id);
	}


	return topic;


}
	@Override
	public List<Topic> findTopicsByCourse(String course_name ) {
		// TODO Auto-generated method stub
		return topicRepository.findByCourseName(course_name);
	}

	@Override
	public Topic saveTopic(Topic topic) {
		String topicName=topic.getTopicName();


		return topicRepository.save(topic);

	}




	@Override
	public void  deleteById(int id) {
		Optional<Topic> topic = topicRepository.findById(id);

		if (!topic.isPresent()) {
			throw new RuntimeException("Topic id not found - " + id);
		}

		topicRepository.deleteById(id);

	}


}






