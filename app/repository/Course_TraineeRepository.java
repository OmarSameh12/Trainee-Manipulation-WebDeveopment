package com.springboot.first.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.first.app.model.Course_Trainee;

@Repository
public interface Course_TraineeRepository extends JpaRepository<Course_Trainee,Long>{
	
}
