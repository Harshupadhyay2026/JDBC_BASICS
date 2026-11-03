package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {

 private StudentRepository studentRepository;

    public StudentServices (StudentRepository studentRepository){

        this.studentRepository=studentRepository;
    }

    @Transactional
    public void createstudent(Student student ){
        studentRepository.save(student);
    }


     @Transactional
    public Student getstudentbyid(Long id){
        return studentRepository.findbyid(id);
    }

    @Transactional
    public void updatestudent (Student studentreq,Long id) {

        Student student1 = studentRepository.findbyid(id);

        if (student1 == null) {
            throw new RuntimeException("Student not found");
        }

          //  studentRepository.detach(student1);

          //  student1=studentRepository.attachAgain(student1);

            student1.setName(studentreq.getName());
            studentRepository.flush();

            student1.setEmail(studentreq.getEmail());
            studentRepository.flush();

            student1.setAge(studentreq.getAge());
            studentRepository.flush(); //3 baar update query chalegi
        }

        @Transactional
        public void deletestudent (Long id){

            Student student = studentRepository.findbyid(id);

            if (student == null) {
                throw new RuntimeException("Student not found");
            }
            studentRepository.remove(student);
        }
    }


