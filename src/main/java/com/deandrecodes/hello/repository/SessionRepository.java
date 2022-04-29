package com.deandrecodes.hello.repository;

import com.deandrecodes.hello.model.Session;

import org.springframework.data.jpa.repository.JpaRepository;

//Session repository using Spring data JpaRepository to apply Basic Crud Repository prenciples
public interface SessionRepository extends JpaRepository<Session, Long> {
    
}
