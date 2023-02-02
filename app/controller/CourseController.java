package com.springboot.first.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.first.app.model.Course;
import com.springboot.first.app.model.Course_Trainee;
import com.springboot.first.app.model.University;
import com.springboot.first.app.service.CourseService;
import com.springboot.first.app.service.CourseServiceImpl;

@RestController
@RequestMapping("api/course")
@CrossOrigin("http://localhost:4200/")

public class CourseController {
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity addCourse(@RequestBody Course course){
		ResponseEntity responseEntity=new ResponseEntity<Course>(courseService.addCourse(course), HttpStatus.CREATED);
		Course Repcourse=(Course) responseEntity.getBody();
		if(Repcourse.getId()==0 ) {
			return new ResponseEntity<String>("Course is already entered before",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@PutMapping("/update")
	public ResponseEntity<Course> updateuser(@RequestBody Course course){
		return new ResponseEntity<Course>(courseService.addCourse(course), HttpStatus.OK);
	}	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable("id")long id){
		courseService.deleteCourse(id);
		return new ResponseEntity<String>("Course is deleted successfully",HttpStatus.OK);
	}	
	
	@GetMapping("/returnall")
	public List<Course> getallcourses(){
		return courseService.retallcourses();
		
	}
	
	
	
	
	@GetMapping("return/{id}")
	public Course retCourse(@PathVariable("id") long id){
		return courseService.retCourse(id);
	}
	
	
	
	
	@GetMapping("/returnall2")
	public List<Course_Trainee> returnallCourses(){
		return courseService.returnallCourses();
	}
	
	
	
}
