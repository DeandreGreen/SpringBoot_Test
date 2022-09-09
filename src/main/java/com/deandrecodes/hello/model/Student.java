//package com.deandrecodes.hello.model;
//
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.util.Objects;
//
////Student Model used to model a "Student" entity in database
//@Entity
////Data Annotation is Used to remove the need for writing getters and setter
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//public class Student {
//    //Id's are generated and assigned as the parent Id of a Student
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String address;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Student student = (Student) o;
//        return id != null && Objects.equals(id, student.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
//}
