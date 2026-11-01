package org.example;

import org.example.model.Student;
import org.example.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hellow World");

        StudentRepository studentRepository = new StudentRepository();

      //  studentRepository.createuser(new Student("Rohit","rohit@gmail.com",20));
       // studentRepository.UpdateUser(new Student("Rohit Negi","rohit5@gmail.com",20),2);


      // studentRepository.createuser();

      //  studentRepository.UpdateUser();

      // studentRepository.DeleteUser(2L);

       studentRepository.getStudent();

      //  studentRepository.CompleteCRUD();

    }}

