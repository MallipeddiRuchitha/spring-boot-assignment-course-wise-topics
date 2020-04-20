package com.ruchitha.coursewisetopicsdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
// define fields

	
	@Id
	@Column(name="course_name")
	private String course_name;
	
	@Column(name="course_description")
	private String course_description;
	
		


	@Override
	public String toString() {
		return "Course [course_name=" + course_name + ", course_description=" + course_description
				+ "]";
	}

	@OneToMany(mappedBy = "course",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Topic> topic;

	/*public String getCourse_name() {
		return course_name;
	}


	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}


	public String getCourse_description() {
		return course_description;
	}


	public void setCourse_description(String course_description) {
		this.course_description = course_description;
	}
	*/
	


}








