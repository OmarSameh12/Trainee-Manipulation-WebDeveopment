package com.springboot.first.app.repository;

import java.util.List;

import com.springboot.first.app.model.Course;
import com.springboot.first.app.model.Course_Trainee;
import com.springboot.first.app.model.Trainee;
import com.springboot.first.app.model.University;

public interface CustomRepository {
	List<String> searchTrainee(String state,String city,String course);
	 List<Course_Trainee> retrunallCourses();
		public List GetUni();

	
}
