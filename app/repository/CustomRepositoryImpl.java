package com.springboot.first.app.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.first.app.model.Course;
import com.springboot.first.app.model.Course_Trainee;
import com.springboot.first.app.model.Trainee;
import com.springboot.first.app.model.University;

@Repository
public class CustomRepositoryImpl implements CustomRepository {

	EntityManager entitymanager;
	@Autowired

	public CustomRepositoryImpl(EntityManager entitymanager) {
		super();
		this.entitymanager = entitymanager;
	}

	@Override
	public List searchTrainee(String state1,String city1,String area1) {
		Session session=entitymanager.unwrap(Session.class);

Query query=session.createQuery("select distinct t from Trainee as t inner join t.courses as ts inner join t.university as uni where"
				+ " ts.area=?2 and uni.state=?0 and uni.city=?1 ");
		query.setString(0,state1);
		query.setString(1,city1);
		query.setString(2,area1); 
		List list=query.list();
	
		return list;
	}

	
	public List<Course_Trainee> retrunallCourses(){
		Session session= entitymanager.unwrap(Session.class);
		Query query=session.createQuery("select c from Course_Trainee c");
		List<Course_Trainee> courses=query.list();
		return courses;
	}
	
	public List GetUni(){
		Session session=entitymanager.unwrap(Session.class);
		Query query=session.createQuery("select distinct u.name, t.name, t.enrollment,t.dateOfEnrollmetent , tcc.name,tcc.acronym,"
				+ " tcc.area from Trainee as t join t.university as u join t.courses as tcc");
				
				List list=query.list();
			
				return list;
	}	
}