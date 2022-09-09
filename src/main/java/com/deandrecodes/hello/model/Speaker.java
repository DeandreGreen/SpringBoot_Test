//package com.deandrecodes.hello.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.*;
//import org.hibernate.Hibernate;
//import org.hibernate.annotations.Type;
//
//import javax.persistence.*;
//import java.util.List;
//import java.util.Objects;
//
////Student Model used to model a "Student" entity in database
//@Entity(name = "speakers")
////ignore relationsional data
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
////Data Annotation is Used to remove the need for writing getters and setter
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//public class Speaker {
//    //Id's are generated and assigned as the parent Id of a Student
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long speaker_id;
//
//    private String first_name;
//    private String last_name;
//    private String title;
//    private String company;
//    private String speaker_bio;
//
//    //Marks as an large object to help JPA manage it
//    @Lob
//    //Helps hibernate handle binary data through JPA
//    @Type(type="org.hibernate.type.BinaryType")
//    private byte[] speaker_photo;
//
//    //Marks the other side of the Many to many join made on the speaker table
//    @ManyToMany(mappedBy = "speakers")
//    //Prevents back serialization to the sessions
//    @JsonIgnore
//    @ToString.Exclude
//    private List<Session> sessions;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Speaker speaker = (Speaker) o;
//        return speaker_id != null && Objects.equals(speaker_id, speaker.speaker_id);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
//}
