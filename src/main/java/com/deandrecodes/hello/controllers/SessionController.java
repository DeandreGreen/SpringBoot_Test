package com.deandrecodes.hello.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.deandrecodes.hello.model.Session;
import com.deandrecodes.hello.repository.SessionRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    // Retrieves all sessions
    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    // Retrieves a session by id
    @GetMapping("/{id}")
    public ResponseEntity<Session> getStudentById(@PathVariable Long id) {
        try {
            Session session = sessionRepository.getById(id);
            return new ResponseEntity<Session>(session,HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Session>(HttpStatus.NOT_FOUND);
        }
    }

    // Creates a new session
    @PostMapping
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    // Deletes a session by id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        // Add check for available session
        sessionRepository.deleteById(id);
    }

    // Updates a session
    @PutMapping("/{id}")
    public ResponseEntity<Session> update(@RequestBody Session session, @PathVariable Long id) {
        try {
            Session targetSession = sessionRepository.getById(id);
            // ignores Primary Key for Update
            BeanUtils.copyProperties(session, targetSession, "session_id");
            sessionRepository.saveAndFlush(targetSession);
            return new ResponseEntity<>(targetSession, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Session>(HttpStatus.NOT_FOUND);
        }
    }
}
