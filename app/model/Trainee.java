package com.springboot.first.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
@Table
public class Trainee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private long id; 
	 private String name;
	 private String enrollment;
	 @JsonFormat(pattern="yyyy-MM-dd")
	 private Date dob; 
	 @JsonFormat(pattern="yyyy-MM-dd")
	 private Date dateOfEnrollmetent;
	 private String situation;
	 @ManyToMany(mappedBy="students",cascade=CascadeType.ALL)
	 private Collection<Course> courses=new ArrayList<Course>();
	 
	 @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	 @JoinColumn(name="University")
	 private University university;
	 @OneToMany(mappedBy="student")
	 @JsonIgnore
	 private Collection<Course_Trainee> course_trainee=new ArrayList(); 
	 
	 public Trainee() {
			super();
			this.id = 0;
			this.name = "";
			this.enrollment = "";
			this.dob = new Date();
			this.dateOfEnrollmetent = new Date();
			this.situation = "";
			this.university = null;
			this.courses=null;
		}
	 
	 public Trainee(long id, String name, String enrollment, Date dob, Date dateOfEnrollmetent, String situation,
			University university, Collection<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.enrollment = enrollment;
		this.dob = dob;
		this.dateOfEnrollmetent = dateOfEnrollmetent;
		this.situation = situation;
		this.university = university;
		this.courses=courses;
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
	public String getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDateOfEnrollmetent() {
		return dateOfEnrollmetent;
	}
	public void setDateOfEnrollmetent(Date dateOfEnrollmetent) {
		this.dateOfEnrollmetent = dateOfEnrollmetent;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	
	public University getUni() {
		return university;
	}
	public void setUni(University uni) {
		this.university = uni;
	}

	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Collection<Course_Trainee> getCourse_trainee() {
		return course_trainee;
	}

	public void setCourse_trainee(Collection<Course_Trainee> course_trainee) {
		this.course_trainee = course_trainee;
	}
	
	


}
	

