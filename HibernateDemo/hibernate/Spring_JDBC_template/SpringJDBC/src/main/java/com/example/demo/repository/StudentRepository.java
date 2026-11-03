package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.services.StudentRowMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

  @PersistenceContext
  private EntityManager entityManager;

  //create
  public  void save (Student student) {

    entityManager.persist(student);
  }

  // if we save million of student at a time --->>>

    public void saveAll(List<Student> students){

    int count = 0;
    for (Student student: students){

        entityManager.persist(student);
        count++;

      if(count%100 == 0){
        entityManager.flush();
        entityManager.clear();
          entityManager.refresh(student);//if we change anything in database directly( through sql editor app)-->it will refresh and changes in p.context

        //used to manage large entity object data coming in persistence context container
        //to manage it we flush() entity object at every 100 count back to database and make container empty
      }
    }

  }

  //read
    public Student findbyid(Long id){

      return entityManager.find(Student.class,id);
    }

    //delete
    public void remove(Student student){
      entityManager.remove(student);
    }

    //detach

     public void detach(Student student){
             entityManager.detach(student);   // if detached then student entity removed from persistent context and updation methode cant be done even after fetching entiy

  }


  //merge

    public Student attachAgain(Student student) {
      return entityManager.merge(student);  //used to merge the detached entity object back to persistent context so updation can be done again
    }
      public void flush(){
        entityManager.flush();  //used to reflect changes in database by writing queries according to changes
      }
    }


