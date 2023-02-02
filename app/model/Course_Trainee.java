package com.springboot.first.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name="Course_Trainee")
@Data
public class Course_Trainee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private long student;
	private long course;
	

	public Course_Trainee(long student, long course) {
		super();

		this.student = student;
		this.course = course;
	}
	public Course_Trainee() {
		super();
		this.student =  0;
		this.course = 0;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getStudent() {
		return student;
	}
	public void setStudent(long student) {
		this.student = student;
	}
	public long getCourse() {
		return course;
	}
	public void setCourse(long course) {
		this.course = course;
	}

}
