package com.deandrecodes.hello.service;

import java.util.List;

import com.deandrecodes.hello.model.Student;

//Student service interface to declare data types of Student methods
public interface StudentService {
    public void saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(Integer id);
    public void delete(Integer id);
}
