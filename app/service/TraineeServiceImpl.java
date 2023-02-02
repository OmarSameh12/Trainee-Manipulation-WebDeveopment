package com.springboot.first.app.service;
 
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NamedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import com.springboot.first.app.exception.ResourceNotFoundException;
import com.springboot.first.app.model.*;
import com.springboot.first.app.exception.ResourceNotFoundException;
import com.springboot.first.app.model.Course;
import com.springboot.first.app.model.Trainee;
import com.springboot.first.app.model.University;
import com.springboot.first.app.repository.CourseRepository;
import com.springboot.first.app.repository.Course_TraineeRepository;
import com.springboot.first.app.repository.CustomRepository;
import com.springboot.first.app.repository.TraineeRepository;
import com.springboot.first.app.repository.UniRepository;



@Service
public class TraineeServiceImpl implements TraineeService{
	 TraineeRepository traineeRepository;
	 CustomRepository customRepository;
	 CourseRepository courseRepository;
	 UniRepository uniRepository;
	 Course_TraineeServiceImpl course_traineeService;
	 CourseService courseService;
	@Autowired
	public TraineeServiceImpl(TraineeRepository traineeRepository, CustomRepository customRepository,
			CourseRepository courseRepository, UniRepository uniRepository,
			Course_TraineeServiceImpl course_traineeService) {
		super();
		this.traineeRepository = traineeRepository;
		this.customRepository = customRepository;
		this.courseRepository = courseRepository;
		this.uniRepository = uniRepository;
		this.course_traineeService = course_traineeService;
	}


	@Override
	 public Trainee addUser(Trainee trainee){
		boolean flag=true;
		List<Trainee> list=traineeRepository.findAll();
		for (int i=0;i<list.size();i++) {
			if (trainee.getName().equals(list.get(i).getName()) & trainee.getDob().equals(list.get(i).getDob()) ) {
				flag=false;
				break;
			}
		}
		if(flag) {
			return traineeRepository.save(trainee);
		}
		return trainee;
			
	}

	@Override
	public List<Trainee> getAllUsers() {
		return traineeRepository.findAll(); 
	}


	@Override
	public Trainee getUser(long id) {
		return (Trainee)(traineeRepository.findById(id).get());
	}


	@Override
	public void removeUser(long id) {
		traineeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Trainee","Id",id));
		traineeRepository.deleteById(id);		
	}





	@Override
	public List searchForTrainee(String state, String city, String area) {
		return customRepository.searchTrainee(state, city, area);
	}
	public void  checkCourses(List<Course> list){
		List<Course> courses=courseService.retallcourses();
		for(int i=0;i<list.size();i++) {	
			for (int j=0;j<courses.size();j++) {
				if(list.get(i).getName().equals(courses.get(j).getName() )){
					traineeRepository.deleteById(courses.get(j).getId());
				} 
				
			}
		}
	}
	
}











