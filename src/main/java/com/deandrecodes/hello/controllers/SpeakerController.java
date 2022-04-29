package com.deandrecodes.hello.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.deandrecodes.hello.model.Speaker;
import com.deandrecodes.hello.repository.SpeakerRepository;

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
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    // Retrieves all speakers
    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    // Retrieves a speaker by id
    @GetMapping("/{id}")
    public ResponseEntity<Speaker> getStudentById(@PathVariable Long id) {
        try {
            Speaker speaker = speakerRepository.getById(id);
            return new ResponseEntity<Speaker>(speaker,HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Speaker>(HttpStatus.NOT_FOUND);
        }
    }

    // Creates a new speaker
    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
        // saves an entity and commits changes instantly
        return speakerRepository.saveAndFlush(speaker);
    }

    // Deletes a speaker by id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        // Add check for available speaker
        speakerRepository.deleteById(id);
    }

    // Updates a speaker
    @PutMapping("/{id}")
    public ResponseEntity<Speaker> update(@RequestBody Speaker speaker, @PathVariable Long id) {
        try {
            Speaker targetSpeaker = speakerRepository.getById(id);
            //ignores Primary Key for Update
            BeanUtils.copyProperties(speaker, targetSpeaker, "speaker_id");
            speakerRepository.saveAndFlush(targetSpeaker);
            return new ResponseEntity<>(targetSpeaker,HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Speaker>(HttpStatus.NOT_FOUND);
        }
    }
}
