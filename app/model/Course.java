package com.springboot.first.app.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.first.app.service.CourseService;

import lombok.Data;

@Entity 
@Data
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	protected String name;
	private String acronym;
	protected String area;
	@ManyToMany
	private Collection<Trainee> students=new ArrayList<Trainee>();
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	 @JoinColumn(name="University_Id")
	 private University university;
	@OneToMany(mappedBy="course")
	@JsonIgnore
	private Collection<Course_Trainee> course_trainee=new ArrayList<Course_Trainee>();
	
	
	public Course( String name, String acronym, String area, Collection<Trainee> students, University unii) {
		super();
		this.name = name;
		this.acronym = acronym;
		this.area = area;
		CourseService courseService;
		this.university = unii;
	}

	
	public Course() {
		super();
		this.id = 0;
		this.name = "";
		this.acronym = "";
		this.area = "";
		this.university=null;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	
	
	
	
	

	
}
