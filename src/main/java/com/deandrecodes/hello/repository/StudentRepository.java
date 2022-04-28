package com.deandrecodes.hello.repository;

import com.deandrecodes.hello.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Student repository using Spring data JpaRepository to apply Basic Crud Repository prenciples
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    
}
 