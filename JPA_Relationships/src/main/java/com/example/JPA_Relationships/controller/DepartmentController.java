package com.example.JPA_Relationships.controller;

import com.example.JPA_Relationships.model.oneTOMany.Department;
import com.example.JPA_Relationships.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/department")

public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createdepartment(
            @RequestBody Department department
    ) {
        departmentService.createDepartment(department);
        return ResponseEntity.ok("Done");
    }


    @PostMapping("/withstudent")
    public ResponseEntity<String> createdepartment(
            @RequestBody Department department,
            @RequestParam String studentName){

     departmentService.createDepartment(department,studentName);
        return ResponseEntity.ok("Done");
    }
}
