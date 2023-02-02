package com.springboot.first.app.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.app.model.Course;
import com.springboot.first.app.model.Course_Trainee;
import com.springboot.first.app.model.Trainee;
import com.springboot.first.app.model.University;
import com.springboot.first.app.service.CourseService;
import com.springboot.first.app.service.Course_TraineeService;
import com.springboot.first.app.service.TraineeService;
@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/trainee")

public class TraineeController {
	private TraineeService traineeService;
	private CourseService courseService;
	private Course_TraineeService course_traineeService;
	
 
	public TraineeController(TraineeService traineeService, CourseService courseService,
			Course_TraineeService course_traineeService) {
		super();
		this.traineeService = traineeService;
		this.courseService = courseService;
		this.course_traineeService = course_traineeService;
	}

	//Search for good candidates
	@GetMapping("search-state/{state}/city/{city}/area/{area}")
	public List SearchForTrainees(@PathVariable("state")String state,@PathVariable("city")String city
			,@PathVariable("area")String area){
		List list= traineeService.searchForTrainee(state,city,area);
		return list;
		
	}
	
	//create trainee profile record
	@PostMapping("/create")
	public ResponseEntity addUser(@RequestBody Trainee trainee){
		
		ResponseEntity responseEntity=new ResponseEntity<Trainee>(traineeService.addUser(trainee), HttpStatus.CREATED);
		Trainee Reptrainee=(Trainee) responseEntity.getBody();
		if(Reptrainee.getId()==0 ) {
			return new ResponseEntity<String>("User is already entered before",HttpStatus.BAD_REQUEST);
		}
		List<Course> trainecourses= (List<Course>) trainee.getCourses();
		for(int i=0;i<trainecourses.size();i++) {
			Course_Trainee coursetrainee=new Course_Trainee(trainee.getId(),trainecourses.get(i).getId());
			course_traineeService.addRec(coursetrainee);
		}
		return responseEntity;
	}
	@PutMapping("/update")
	public ResponseEntity<Trainee> updateuser(@RequestBody Trainee trainee){
		return new ResponseEntity<Trainee>(traineeService.addUser(trainee), HttpStatus.OK);
	}
	
	

	//return all trainees 
	@GetMapping("/returnall")
	public List<Trainee> getAllUsers(){
		List<Trainee> trainees=(List<Trainee>)traineeService.getAllUsers();
		List<Course_Trainee> course_trainee=courseService.returnallCourses(); 
		for(int i =0;i<trainees.size();i++) {
			for(int j=0;j<course_trainee.size();j++) {
				if(trainees.get(i).getId()==course_trainee.get(j).getStudent()) {
					trainees.get(i).getCourses().add(courseService.retCourse(course_trainee.get(j).getCourse()));
				}
			}
		}

			return trainees;
	}
	//return trainee with specific id
	@GetMapping("/return/{id}")
	public Trainee getUser(@PathVariable("id") long id){
		return traineeService.getUser(id);
	}
	//delete trainee profile
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")long id ){
		traineeService.removeUser(id);
		return new ResponseEntity<String>("Trainee deleted successfully",HttpStatus.OK);
		}
	
	
	
}
