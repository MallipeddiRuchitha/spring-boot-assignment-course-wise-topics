package com.ruchitha.coursewisetopicsdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="topic")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Topic {


	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="tid")
	private int id;
	
	@Column(name="topic")
	private String topicName;
	@Column(name="level")
	private String level;
	
	@ManyToOne()
    @JoinColumn(name = "course_name")
     private Course course;
	

	/*public Topic(){
		
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topic) {
		this.topicName = topic;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Topic(int id, String topic, Course course, String level) {
		this.id = id;
		this.topicName = topic;
		this.course = course;
		this.level = level;
	}
	
	
	*/
	
	
	
	
	

}
	