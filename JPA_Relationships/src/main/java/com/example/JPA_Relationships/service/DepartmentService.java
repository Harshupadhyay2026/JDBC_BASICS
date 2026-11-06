package com.example.JPA_Relationships.service;

import com.example.JPA_Relationships.model.oneTOMany.Department;
import com.example.JPA_Relationships.model.oneTOMany.Student;
import com.example.JPA_Relationships.repository.DepartmentRepository;

import com.example.JPA_Relationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;

    public DepartmentService (DepartmentRepository departmentRepository,
                              StudentRepository studentRepository){

        this.departmentRepository=departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createDepartment(Department department){
        departmentRepository.save(department);
    }


    @Transactional
    public void createDepartment(Department department,
                              String studentName){

        Student student= new Student();
        student.setName(studentName);
        student.setDepartment(department);

        if(department.getStudents()==null) department.setStudents(new ArrayList<>());


        department.getStudents().add(student); //adding each student in department

        studentRepository.save(student);
        departmentRepository.save(department);
    }


}
