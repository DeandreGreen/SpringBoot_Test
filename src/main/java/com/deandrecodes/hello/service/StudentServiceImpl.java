package com.deandrecodes.hello.service;

import java.util.List;

import com.deandrecodes.hello.model.Student;
import com.deandrecodes.hello.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    
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
