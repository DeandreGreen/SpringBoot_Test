//package com.deandrecodes.hello.controllers;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//import com.deandrecodes.hello.model.Student;
//import com.deandrecodes.hello.service.StudentService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////Student Request Controller
//@RestController
//@RequestMapping("/student")
//public class StudentController {
//    @Autowired
//    private StudentService studentService;
//
//    //Post Mapping to creat a Student
//    @PostMapping("/add")
//    public String add (@RequestBody Student student){
//        studentService.saveStudent(student);
//        return "new student is added";
//    }
//
//    //Get Mapping to retrieve all Students in database
//    @GetMapping("/getAll")
//    public List<Student> getAllStudents(){
//        return studentService.getAllStudents();
//    }
//
//    //Get Mapping to retrieve one Student by its Id
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
//        try {
//            Student student = studentService.getStudentById(id);
//            return new ResponseEntity<Student>(student,HttpStatus.OK);
//
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    //Put Mapping to update a Student that is already in the database
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable Integer id) {
//        try {
//            studentService.getStudentById(id);
//            studentService.saveStudent(student);
//            return new ResponseEntity<>(HttpStatus.OK);
//
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    //Delete Mapping to delete a student by its Id
//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id) {
//        studentService.delete(id);
//        return "Deleted Student with id " + id;
//    }
//
//}
