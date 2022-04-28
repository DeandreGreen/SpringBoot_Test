package com.deandrecodes.hello.service;

import java.util.List;

import com.deandrecodes.hello.model.Student;
import com.deandrecodes.hello.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//We mark beans with @Service to indicate that they're holding the business logic
@Service
public class StudentServiceImpl implements StudentService{
    
    //marks a Constructor, Setter method, Properties and Config() method as to be autowired that is 'injecting beans'(Objects) at runtime by Spring Dependency Injection mechanism
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id){
        return studentRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id){
        studentRepository.deleteById(id);
    }
}
