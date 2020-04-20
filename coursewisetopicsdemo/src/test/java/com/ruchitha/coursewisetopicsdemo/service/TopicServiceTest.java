package com.ruchitha.coursewisetopicsdemo.service;

import com.ruchitha.coursewisetopicsdemo.dao.CourseRepository;
import com.ruchitha.coursewisetopicsdemo.dao.TopicRepository;
import com.ruchitha.coursewisetopicsdemo.entity.Course;
import com.ruchitha.coursewisetopicsdemo.entity.Topic;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class TopicServiceTest {
    private TopicRepository topicRepository;
    private TopicService topicService;
    @BeforeEach
    public  void init(){
        topicRepository=mock(TopicRepository.class);
        topicService=new TopicServiceImpl(topicRepository);
        //MockitoAnnotations.initMocks(this);
    }
    @Test
    void findTopicsByCourse() {
        Mockito.when(topicRepository.findByCourseName("java")).thenReturn(Stream.of(new Topic(1,"data types","easy",null),new Topic(2,"abstraction","easy",null)
        )
                .collect(Collectors.toList()));
        assertEquals(2,topicService.findTopicsByCourse("java").size());
    }

    @Test
    void saveTopic() {
        Topic topic= new Topic(1,"data types","easy",null);


        when(topicRepository.save(topic)).thenReturn(topic);
        assertEquals(topic,topicService.saveTopic(topic));

    }

    @Test
    void findById() {
        Topic topic= new Topic(1,"data types","easy",null);
        when(topicRepository.findById(1)).thenReturn(of(topic));
        assertEquals(of(topic),topicService.findById(1));


        try{
            topicService.findById(2);
            fail("This should have thrown an exception");
        }
        catch(Exception exception){

            assertEquals("Topic id not found - 2",exception.getMessage());
        }
    }

    @Test
    void deleteById() {

        Topic topic= new Topic(1,"data types","easy",null);
        when(topicRepository.findById(1)).thenReturn(of(topic));

        topicService.deleteById(1);
        verify(topicRepository,times(1)).deleteById(1);


        try {
            topicService.deleteById(2);
            fail("This should have thrown an exception");
        }
        catch(Exception exception ){

            Assert.assertEquals("Topic id not found - 2",exception.getMessage());
        }

        verify(topicRepository,times(0)).deleteById(2);


    }
    }
