package com.example.StudentsCont;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomExce.IdNotFound;
import com.example.StudentsService.StudentsService;
import com.example.StudentsService.StudentsSeviceInt;
import com.example.studetsEntity.StudentsEntity;

import jakarta.annotation.PostConstruct;

@RestController
@EnableCaching
public class StudentsController {
	
	Logger logger=LoggerFactory.getLogger(StudentsController.class);
	@Autowired
	private StudentsSeviceInt seviceInt;
	
	
	@PostConstruct
	public void postSave() {
		logger.warn("starting postconstuct method to post some records int H2-Db");
		List<StudentsEntity> sts=new ArrayList<>();
		sts.add(new StudentsEntity(1, "bhaskar", "alts", "ECE", "1234567890", "india"));
		sts.add(new StudentsEntity(2, "arun", "jntu", "CSE", "1234756890", "india"));
		sts.add(new StudentsEntity(3, "ram", "pvkk", "ECE", "1234509876", "india"));
		sts.add(new StudentsEntity(4, "shyam", "alts", "ME", "5432167890", "india"));
		for(StudentsEntity st:sts) {
			logger.info("in post construct for each method started");
			 seviceInt.save(st);
		}
		
		
	}
	
	
	@GetMapping("/home/greet")
	public String greet() {
		logger.info("greet message");
		return "hello bhaskar";
	}
	@PostMapping("/admin/save")
	public ResponseEntity<StudentsEntity> save(@RequestBody StudentsEntity st){
		logger.info("save method called to post record" );
		return new ResponseEntity<StudentsEntity>(seviceInt.save(st),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/admin/delete/id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable ("id") int id){
		logger.info("delete method called to delete record"+id );
		return new ResponseEntity<String>(seviceInt.deleteById(id),HttpStatus.BAD_REQUEST);
	}
	@PutMapping("/admin/update")
	public ResponseEntity<StudentsEntity> update(@RequestBody StudentsEntity st){
		logger.info("update method called to update record"+st.getId() );
		return new ResponseEntity<StudentsEntity>(seviceInt.save(st),HttpStatus.ACCEPTED);
	}
	@GetMapping("/user/get/id/{id}")

	public ResponseEntity<StudentsEntity> getById(@PathVariable ("id") int id){
		logger.info("get method called to get record"+id );
	 StudentsEntity st=seviceInt.getById(id);
	
		return new ResponseEntity<StudentsEntity>(st,HttpStatus.ACCEPTED);
	 
	}
	@GetMapping("/user/getall")
	public ResponseEntity<List<StudentsEntity>> get(){
		logger.info("get method called to get all records" );
		return new ResponseEntity<List<StudentsEntity>>(seviceInt.getall(),HttpStatus.ACCEPTED);
	}
	
	
	
}

