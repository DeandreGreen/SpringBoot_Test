package com.deandrecodes.hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//Student Model used to model a "Student" entity in database
@Entity
//Data Annotation is Used to remove the need for writing getters and setter
@Data
public class Student {
    //Id's are generated and assigned as the parent Id of a Student
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    public Student() {
    }

}
