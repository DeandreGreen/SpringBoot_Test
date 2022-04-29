package com.deandrecodes.hello.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Type;

import lombok.Data;

//Student Model used to model a "Student" entity in database
@Entity(name = "speakers")
//ignore relationsional data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//Data Annotation is Used to remove the need for writing getters and setter
@Data
public class Speaker {
    //Id's are generated and assigned as the parent Id of a Student
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speaker_id;

    private String first_name;
    private String last_name;    
    private String title;
    private String company;
    private String speaker_bio;

    //Marks as an large object to help JPA manage it
    @Lob
    //Helps hibernate handle binary data through JPA
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] speaker_photo;

    //Marks the other side of the Many to many join made on the speaker table
    @ManyToMany(mappedBy = "speakers")
    //Prevents back serialization to the sessions
    @JsonIgnore
    private List<Session> sessions;

    public Speaker() {
    }

}
