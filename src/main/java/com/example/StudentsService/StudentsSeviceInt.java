package com.example.StudentsService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studetsEntity.StudentsEntity;

@Service
public interface StudentsSeviceInt {
	

	public StudentsEntity save(StudentsEntity st);
	
	public StudentsEntity update(StudentsEntity st);
	public String deleteById(int id);
	public StudentsEntity getById(int id);
	public List<StudentsEntity> getall();
	

}
