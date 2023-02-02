package com.springboot.first.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.first.app.model.Trainee;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee,Long>{

}
