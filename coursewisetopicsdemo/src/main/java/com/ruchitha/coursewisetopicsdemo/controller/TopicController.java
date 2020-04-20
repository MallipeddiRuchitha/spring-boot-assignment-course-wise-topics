package com.ruchitha.coursewisetopicsdemo.controller;

import com.ruchitha.coursewisetopicsdemo.entity.Course;
import com.ruchitha.coursewisetopicsdemo.entity.Topic;
import com.ruchitha.coursewisetopicsdemo.service.CourseService;
import com.ruchitha.coursewisetopicsdemo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/topics")
public class TopicController {

	private TopicService topicService;
	private CourseService courseService;
	@Autowired
	public TopicController(TopicService theTopicService, CourseService courseService) {
	topicService = theTopicService;
	this.courseService=courseService;
	}
	




	@GetMapping("/showTopics")
	public String showTopics(@RequestParam("course_name") String course_name,
									Model theModel) {


		List<Topic> topics=topicService.findTopicsByCourse(course_name);
		

		theModel.addAttribute("topics", topics);
		theModel.addAttribute("course_name",course_name);
		

		return "topics/list-topics";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model, @RequestParam("course_name") String course_name) {



    Topic topic=new Topic();

		Optional<Course> course=courseService.findById(course_name);

		model.addAttribute("topic",topic);

		System.out.println(course_name);
		if( course.isPresent() ) {
			model.addAttribute("course", course.get());}


		return "topics/topic-form";
	}


	@PostMapping("/saveTopic")
	public String updateTopic( @ModelAttribute("topic") Topic topic) {
		System.out.println("abc"+topic.getCourse());
		topicService.saveTopic(topic);


		return "redirect:/topics/showTopics?course_name="+topic.getCourse().getCourse_name();
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("topic_id") int id,
									Model model) {



		Optional<Topic> topic=topicService.findById(id);
          System.out.println("abc"+topic.get().getCourse());

		model.addAttribute("topic", topic.get());
		model.addAttribute("course", topic.get().getCourse());

		return "topics/topic-update-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("topic_id") int topicId) {
		Optional<Topic> topic=topicService.findById(topicId);

		topicService.deleteById(topicId);

		return "redirect:/topics/showTopics?course_name="+topic.get().getCourse().getCourse_name();
//

	}

	
	
}


















