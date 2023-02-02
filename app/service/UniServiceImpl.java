package com.springboot.first.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.first.app.exception.ResourceNotFoundException;
import com.springboot.first.app.model.Trainee;
import com.springboot.first.app.model.University;
import com.springboot.first.app.repository.CustomRepository;
import com.springboot.first.app.repository.UniRepository;

@Service
public class UniServiceImpl implements UniService {

	UniRepository uniRepository; 
	CustomRepository customRepository;
	
	@Autowired
	public UniServiceImpl(UniRepository uniRepository, CustomRepository customRepository) {
		super();
		this.uniRepository = uniRepository;
		this.customRepository = customRepository;
	}

	@Override
	public List<University> getAllUsers() {
		List<University> list= uniRepository.findAll();
		return list;
	}



	@Override
	public void deleteUni(long id) {
		uniRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("University","Id",id));
		uniRepository.deleteById(id);		
	}

	@Override
	public University addUni(University university) {
		boolean flag=true;
		List<University> list=uniRepository.findAll();
		for (int i=0;i<list.size();i++) {
			if (university.getName().equals(list.get(i).getName()) & university.getCity().equals(list.get(i).getCity()) ) {
				flag=false;
				break;
			}
		}
		if (flag)
			return uniRepository.save(university);
		return university;
			
		
		
	}

	@Override
	public University retUni(long id) {
		return uniRepository.findById(id).get();
	}

	@Override
	public List showUni() {
		return customRepository.GetUni();
	}

}
