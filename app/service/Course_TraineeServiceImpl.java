package com.springboot.first.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.first.app.model.Course;
import com.springboot.first.app.model.Course_Trainee;
import com.springboot.first.app.model.Trainee;
import com.springboot.first.app.repository.Course_TraineeRepository;

@Service
public class Course_TraineeServiceImpl implements Course_TraineeService{
	public Course_TraineeRepository courseTraineeRepository;

	@Autowired
	public Course_TraineeServiceImpl(Course_TraineeRepository courseTraineeRepository) {
		super();
		this.courseTraineeRepository = courseTraineeRepository;
	}


	public void addRec(Course_Trainee course_trainee){
		courseTraineeRepository.save(course_trainee);
	} 
	
	
	
	
}
