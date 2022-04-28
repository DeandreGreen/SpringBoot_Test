package com.deandrecodes.hello.repository;

import com.deandrecodes.hello.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    
}
 