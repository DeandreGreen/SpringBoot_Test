//package com.deandrecodes.hello.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import javax.persistence.*;
//import java.util.List;
//import java.util.Objects;
//
////Student Model used to model a "Student" entity in database
//@Entity(name = "sessions")
////ignore relationsional data
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
////Data Annotation is Used to remove the need for writing getters and setter
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//public class Session {
//    //Id's are generated and assigned as the parent Id of a Student
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long session_id;
//
//    private String session_name;
//    private String session_description;
//    private Integer session_length;
//
//    //Setting up a many to many relation ship for a mapping join table in your table
//    @ManyToMany
//    //Defines the join Table
//    @JoinTable(
//        name = "session_speakers",
//        //Defines the join Columns for both tables
//        joinColumns = @JoinColumn(name = "session_id"),
//        inverseJoinColumns = @JoinColumn(name = "speaker_id")
//    )
//    @ToString.Exclude
//    private List<Speaker> speakers;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Session session = (Session) o;
//        return session_id != null && Objects.equals(session_id, session.session_id);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
//}
