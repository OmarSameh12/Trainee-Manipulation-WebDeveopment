package com.springboot.first.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.first.app.exception.ResourceNotFoundException;
import com.springboot.first.app.model.Course;
import com.springboot.first.app.model.Course_Trainee;
import com.springboot.first.app.repository.CourseRepository;
import com.springboot.first.app.repository.CustomRepository;

@Service
public class CourseServiceImpl implements CourseService {
	CourseRepository courseRepository;
	CustomRepository customRepository;
	@Autowired
	
	public CourseServiceImpl(CourseRepository courseRepository, CustomRepository customRepository) {
		super();
		this.courseRepository = courseRepository;
		this.customRepository = customRepository;
	}
	
	
	@Override
	public Course addCourse(Course course) {
		boolean flag=true;
		List<Course> list=courseRepository.findAll();
		for (int i=0;i<list.size();i++) {
			if (course.getName().equals(list.get(i).getName()) & course.getArea().equals(list.get(i).getArea())){
				flag=false;
				break;
			}
		}
		if (flag)
			return courseRepository.save(course);
		return course;
	}


	@Override
	public void deleteCourse(long id) {

		courseRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Course","id",id));
		courseRepository.deleteById(id);
	}

	@Override
	public Course retCourse(long id) {
		return courseRepository.findById(id).get();
	}

	@Override
	public List<Course> retallcourses() {
		List<Course> list=courseRepository.findAll();
		return list;
	}

	 
	public void removeDuplicate(long id,String name,String area ) {
		List<Course> list=courseRepository.findAll();
		System.out.println("here");
		for(int i =0;i<list.size();i++){
			if(name.equals( list.get(i).getName()) & area.equals( list.get(i).getArea() )){
				//System.out.println("delete c with id" +course.getId());
				id=list.get(i).getId();
				System.out.println("hereeeee");
				//courseRepository.deleteById(list.get(i).getId());
				break;
			}
		}
		
	}

	@Override
	public List<Course_Trainee> returnallCourses() {
		return customRepository.retrunallCourses(); 
	}
	
	
	
}
