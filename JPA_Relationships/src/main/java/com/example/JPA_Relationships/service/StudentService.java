package com.example.JPA_Relationships.service;

import com.example.JPA_Relationships.model.oneTOMany.Department;
import com.example.JPA_Relationships.model.oneTOMany.Student;
import com.example.JPA_Relationships.repository.DepartmentRepository;
import com.example.JPA_Relationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

    @Service
    public class StudentService {

        private StudentRepository studentRepository;
        private DepartmentRepository departmentRepository;

        public StudentService (StudentRepository studentRepository,
                               DepartmentRepository departmentRepository){

            this.studentRepository=studentRepository;
            this.departmentRepository= departmentRepository;
        }
        @Transactional
        public void createStudent(Student student , Long deptId){
            Department department =
                    departmentRepository.getDepartmentById(deptId);

            student.setDepartment(department);

            department.getStudents().add(student); //adding each student in department

            studentRepository.save(student);
        }


        @Transactional
        public void createStudent(Student student ,String deptName){

            Department department = new Department(); //creating new department
            department.setName(deptName);  //setting name according to param

            student.setDepartment(department);  //setting department into student jo save hokr mila hai
            department.getStudents().add(student);

            departmentRepository.save(department);  //saving it first

            studentRepository.save(student);
        }



    }
