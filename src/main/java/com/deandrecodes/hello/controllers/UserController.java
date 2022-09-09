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

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public List<User> userList() { return userRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        try {
            User user = userRepository.getById(id);
            return new ResponseEntity<User>(user,HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public User create(@RequestBody final User user) { return userRepository.saveAndFlush(user); }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
        try {
            User target = userRepository.getById(id);
            BeanUtils.copyProperties(user, target, "id");
            userRepository.saveAndFlush(user);
            return new ResponseEntity<>(target, HttpStatus.OK);
        } catch(NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

//    This Is an uneeded method and your reminder to take a break dummy
//    @PutMapping("/{id}/event/{eventId}")
//    public ResponseEntity<User> assignEventToUser(@PathVariable Long eventId, @PathVariable Long id, @RequestBody final User user) {
//        try {
//            List<Event> eventsList = new ArrayList<>();
//            User target = userRepository.getById(id);
//
//            Event event = eventRepository.findById(eventId).get();
//            eventsList.add(event);
//
//            user.setEvents(eventsList);
//            BeanUtils.copyProperties(user, target, "id");
//            userRepository.saveAndFlush(user);
//            return new ResponseEntity<>(target, HttpStatus.OK);
//        } catch(NoSuchElementException e) {
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "Deleted id: " + id;
    }
}
