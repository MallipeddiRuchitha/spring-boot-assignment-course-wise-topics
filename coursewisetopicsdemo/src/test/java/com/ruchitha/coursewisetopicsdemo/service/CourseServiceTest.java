package com.ruchitha.coursewisetopicsdemo.service;

import com.ruchitha.coursewisetopicsdemo.dao.CourseRepository;
import com.ruchitha.coursewisetopicsdemo.entity.Course;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
class CourseServiceTest {
    private CourseRepository courseRepository;
    private CourseService courseService;
    @BeforeEach
    public  void init(){
        courseRepository=mock(CourseRepository.class);
        courseService=new CourseServiceImpl(courseRepository);
        //MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() {
        Mockito.when(courseRepository.findAll()).thenReturn(Stream.of(new Course("java","java is a object oriented programming language",null),
                new Course("dbms","dbms is used to manage the database",null)
        )
                .collect(Collectors.toList()));
        assertEquals(2,courseService.findAll().size());
    }

    @Test
    void saveNewCourse() {
        Course course=new  Course("dbms","dbms is used to manage the database",null);

        when(courseRepository.save(course)).thenReturn(course);
        assertEquals(course,courseService.saveNewCourse(course));
       Course course1=new Course("java","java is a object oriented programming language",null);
        when(courseRepository.findById("java")).thenReturn(of(course));

        try{
            courseService.saveNewCourse(course1);
            fail("This should have thrown an exception");
        }
        catch(Exception exception){

            Assert.assertEquals("Course already exists - java",exception.getMessage());
        }


    }

    @Test
    void updateCourse() {
        Course course=new  Course("dbms","dbms is used to manage the database",null);


        when(courseRepository.save(course)).thenReturn(course);

        assertEquals(course,courseService.updateCourse(course));
    }

    @Test
    void findById() {
        Course course=new  Course("dbms","dbms is used to manage the database",null);
        when(courseRepository.findById("dbms")).thenReturn(of(course));
        assertEquals(of(course),courseService.findById("dbms"));


        try{
            courseService.findById("spring");
            fail("This should have thrown an exception");
        }
        catch(Exception exception){

            assertEquals("Course  not found - spring",exception.getMessage());
        }
    }

    @Test
    void deleteById() {
        Course course=new  Course("dbms","dbms is used to manage the database",null);
        when(courseRepository.findById("dbms")).thenReturn(of(course));

        courseService.deleteById("dbms");
        verify(courseRepository,times(1)).deleteById("dbms");


        try {
            courseService.deleteById("java");
            fail("This should have thrown an exception");
        }
        catch(Exception exception ){

            Assert.assertEquals("Course not found - java",exception.getMessage());
        }

        verify(courseRepository,times(0)).deleteById("java");


    }
}