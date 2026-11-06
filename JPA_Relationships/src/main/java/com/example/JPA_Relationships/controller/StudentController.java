package com.example.JPA_Relationships.controller;

import com.example.JPA_Relationships.model.oneTOMany.Student;
import com.example.JPA_Relationships.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
    @RequestMapping("/api/student")

    public class StudentController {

        private StudentService studentservice;

        public StudentController(StudentService studentServices){
            this.studentservice=studentServices;
        }

        @PostMapping("/{deptId}")
        public ResponseEntity<String> createStudent(
                @RequestBody Student student,
                @PathVariable Long deptId){

            studentservice.createStudent(student,deptId);
            return ResponseEntity.ok("Done");
        }


    @PostMapping("/withdepartment")
    public ResponseEntity<String> createStudent(
            @RequestBody Student student,
            @RequestParam String deptName){

        studentservice.createStudent(student,deptName);
        return ResponseEntity.ok("Done");
    }

}
