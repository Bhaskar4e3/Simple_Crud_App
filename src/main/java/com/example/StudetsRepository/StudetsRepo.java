package com.example.StudetsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studetsEntity.StudentsEntity;

@Repository
public interface StudetsRepo extends JpaRepository<StudentsEntity, Integer> {

}
