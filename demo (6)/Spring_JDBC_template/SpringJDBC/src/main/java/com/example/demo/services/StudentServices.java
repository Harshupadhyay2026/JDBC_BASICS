package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {

 private StudentRepository studentRepository;

    public StudentServices (StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public void createstudent(Student student ){
        studentRepository.createstudent(student);
    }

    public List<Student> getallstudent(){
        return studentRepository.getallstudent();
    }

    public Student getstudentbyid(Long id){
        return studentRepository.getstudentbyid(id);
    }

    public void updatestudent (Student student){
        studentRepository.updatestudent(student,student.getId());
    }

    public void deletestudent(Long id){
        studentRepository.deletestudent(id);
    }

}
