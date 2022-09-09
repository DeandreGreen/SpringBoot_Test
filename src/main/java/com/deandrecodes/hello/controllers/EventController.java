package com.deandrecodes.hello.controllers;

import com.deandrecodes.hello.model.Event;
import com.deandrecodes.hello.model.User;
import com.deandrecodes.hello.repository.EventRepository;
import com.deandrecodes.hello.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Event> eventsList() { return eventRepository.findAll(); }

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> get(@PathVariable Long eventId) {
        try {
            Event event = eventRepository.getById(eventId);
            return new ResponseEntity<Event>(event, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/{id}")
    public ResponseEntity<Event> createEventWIthUser(@RequestBody final Event event, @PathVariable Long id) {
        try {
            User user = userRepository.findById(id).get();
            event.setUser(user);
            eventRepository.saveAndFlush(event);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<Event> update(@RequestBody Event event, @PathVariable Long eventId) {
        try {
            Event target = eventRepository.getById(eventId);
            BeanUtils.copyProperties(event, target, "id");
            eventRepository.saveAndFlush(event);
            return new ResponseEntity<>(target, HttpStatus.OK);
        } catch(NoSuchElementException e) {
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{eventId}")
    public String delete(@PathVariable Long eventId) {
        eventRepository.deleteById(eventId);
        return "Deleted id: " + eventId;
    }

}
