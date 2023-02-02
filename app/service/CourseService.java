package com.springboot.first.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.first.app.model.Course;
import com.springboot.first.app.model.Course_Trainee;

@Service
public interface CourseService {
	Course addCourse(Course course);
	void deleteCourse(long id);
	Course retCourse(long id);
	List<Course> retallcourses();
	 void removeDuplicate(long id,String name, String area);
	List<Course_Trainee> returnallCourses();

}
