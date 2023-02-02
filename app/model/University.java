package com.springboot.first.app.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data
public class University {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String district;
	private String state;
	private String city;
	@OneToMany(
				mappedBy="university",
				cascade=CascadeType.ALL
			)
	private Collection<Trainee> students=new ArrayList<Trainee>();
	@OneToMany(
			mappedBy="university",
			cascade=CascadeType.ALL,
			orphanRemoval=true
		)
private Collection<Course> courses=new ArrayList<Course>();
	
	
	
	
	public University(Long id, String name, String address, String district, String state, String city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.district = district;
		this.state = state;
		this.city = city;
	}
	public Long getId() {
		return id;
	}
	public University() {
	super();
	this.id = (long) 0;
	this.name="";
	this.address = "";
	this.district = "";
	this.state = "";
	this.city = "";
	this.courses=null;
	this.students=null;
	
	
}


	public Collection<Course> getCourses() {
		return courses;
	}
	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


	

}
