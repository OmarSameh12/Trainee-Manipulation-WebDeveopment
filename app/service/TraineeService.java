package com.springboot.first.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.first.app.model.Trainee;
import com.springboot.first.app.model.University;

@Service
public interface TraineeService {
	Trainee addUser(Trainee trainee);
	List<Trainee> getAllUsers();
	Trainee getUser(long id);
	void removeUser(long id);
	List searchForTrainee(String state, String city, String area);
}
