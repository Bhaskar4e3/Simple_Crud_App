package com.example.StudentsService;

import java.util.List;
import java.util.Optional;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.CustomExce.IdNotFound;
import com.example.StudetsRepository.StudetsRepo;
import com.example.studetsEntity.StudentsEntity;

@Service
public class StudentsService implements StudentsSeviceInt {

	org.slf4j.Logger logger=LoggerFactory.getLogger(StudentsService.class);
	@Autowired
	private StudetsRepo studetsRepo;
	@Override
	@CachePut(cacheNames = "students",key = "#st.getId")
	public StudentsEntity save(StudentsEntity st) {
		 
		return studetsRepo.save(st);
	}

	@Override
	public StudentsEntity update(StudentsEntity st) {
	
		return studetsRepo.save(st);
	}

	@Override
	@CacheEvict(cacheNames = "students",key = "#id")
	public String deleteById(int id) {
		logger.warn("delete by id method called "+id);
		if(studetsRepo.existsById(id)) {
			logger.info("succefully deleted "+id+" record from db");
			studetsRepo.deleteById(id);
			return "deleted successfully";
		}
		else {
			logger.error("id not found that user trying to delete "+id);
			return "id not found in database"+id+" ";
		}
	
	}

	@Override
	@Cacheable(cacheNames = "students",key = "#id")
	public StudentsEntity getById(int id) {
		logger.warn("find by id method called "+id);
  Optional<StudentsEntity> st=studetsRepo.findById(id);
  
  if(st.isEmpty()) {
	  logger.error("user is trying to record that not existed "+id);
	  throw new IdNotFound("the id "+id+" is not present in data server");
  }
  else {
	  logger.info("find by id method called successfully "+id);
    return st.get();
  }
	}

	@Override
	@Cacheable(cacheNames = "students")
	public List<StudentsEntity> getall() {
		logger.info("find all method called");
		return studetsRepo.findAll();
	}
	

}
