package com.deandrecodes.hello.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

//Student Model used to model a "Student" entity in database
@Entity(name = "sessions")
//ignore relationsional data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//Data Annotation is Used to remove the need for writing getters and setter
@Data
public class Session {
    //Id's are generated and assigned as the parent Id of a Student
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;

    private String session_name;
    private String session_description;
    private Integer session_length;

    //Setting up a many to many relation ship for a mapping join table in your table
    @ManyToMany
    //Defines the join Table
    @JoinTable(
        name = "session_speakers",
        //Defines the join Columns for both tables
        joinColumns = @JoinColumn(name = "session_id"),
        inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers;

    public Session() {
    }

}
