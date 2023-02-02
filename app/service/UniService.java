package com.springboot.first.app.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.springboot.first.app.model.University;

@Service
public interface UniService {
	public List<University> getAllUsers();
	public void deleteUni(long id);
	public University addUni(University university);
	public University retUni(long id);
	public List showUni();
	
}
