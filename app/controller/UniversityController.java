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

import com.springboot.first.app.model.Trainee;
import com.springboot.first.app.model.University;
import com.springboot.first.app.service.UniService;

@RestController
@RequestMapping("/api/uni")
@CrossOrigin("http://localhost:4200/")

public class UniversityController {
	private UniService uniService;
	
	public UniversityController(UniService uniService) {
		super();
		this.uniService = uniService;
	}
	@PostMapping("create")
	public ResponseEntity addUni(@RequestBody University uni){
		ResponseEntity responseEntity=new ResponseEntity<University>(uniService.addUni(uni), HttpStatus.CREATED);
		University Reptrainee=(University) responseEntity.getBody();
		if(Reptrainee.getId()==0 ) {
			return new ResponseEntity<String>("University is already entered before",HttpStatus.BAD_REQUEST);
		}
		else {
			return responseEntity;
		}
			
		}
	
	@PutMapping("/update")
	public ResponseEntity<University> updateuser(@RequestBody University university){
		return new ResponseEntity<University>(uniService.addUni(university), HttpStatus.OK);
	}	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUni(@PathVariable("id")long id){
		uniService.deleteUni(id);
		return new ResponseEntity<String>("University deleted successfully",HttpStatus.OK);
		}
	
	@GetMapping("/returnall")
	public List<University> getAllUsers(){
		return uniService.getAllUsers();
	}
	@GetMapping("return/{id}")
	public University retUni(@PathVariable ("id") long id ){
		return uniService.retUni(id);
		
	}
	
	@GetMapping("returnUniversityWithData")
	public List getAllUni(){
		return uniService.showUni();
		
	}
		
		
	
}
