package com.deandrecodes.hello.repository;

import com.deandrecodes.hello.model.Speaker;

import org.springframework.data.jpa.repository.JpaRepository;

//Speaker repository using Spring data JpaRepository to apply Basic Crud Repository prenciples
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    
}
