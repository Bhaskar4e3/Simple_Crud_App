package com.example.studetsEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentsDetails")
public class StudentsEntity {
	@Id
	private int id;
	private String name;
	private String college;
	private String course;
	private String mobile;
	private String country;
	public StudentsEntity(int id, String name, String college, String course, String mobile, String country) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.course = course;
		this.mobile = mobile;
		this.country = country;
	}
	public StudentsEntity() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "StudentsEntity [id=" + id + ", name=" + name + ", college=" + college + ", course=" + course
				+ ", mobile=" + mobile + ", country=" + country + "]";
	}
	

}
