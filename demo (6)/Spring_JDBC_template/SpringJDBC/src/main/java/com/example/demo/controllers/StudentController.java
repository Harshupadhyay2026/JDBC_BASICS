package com.example.demo.controllers;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.services.StudentServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")

public class StudentController {

    private StudentServices studentservices;

    public StudentController(StudentServices studentServices){
        this.studentservices=studentServices;
    }

    @PostMapping
    public ResponseEntity<String> createstudent(@RequestBody Student student){
        studentservices.createstudent(student);
        return ResponseEntity.ok("creation DONE");
    }

    @GetMapping
    public ResponseEntity<List<Student>> getallstudent(){
       List<Student> student =  studentservices.getallstudent();
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getstudentbyid(@PathVariable Long id){
        Student student =  studentservices.getstudentbyid(id);
        return ResponseEntity.ok(student);}

    @PatchMapping
        public ResponseEntity<String> updatestudent(@RequestBody Student student) {
        studentservices.updatestudent(student);
        return ResponseEntity.ok("update done");
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<String> deletestudent(@PathVariable Long id){
             studentservices.deletestudent(id);
            return ResponseEntity.ok("deletion done");
    }

}
