package com.springboot.first.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.first.app.model.University;

public interface UniRepository extends JpaRepository<University,Long>{

}
