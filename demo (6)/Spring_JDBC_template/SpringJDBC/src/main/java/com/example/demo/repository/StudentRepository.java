package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.services.StudentRowMapper;
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

        String url = "jdbc:mysql://localhost:3306/Student_jdbc?allowPublicKeyRetrieval=true&useSSL=false";
        String username = "root";
        String password = "Harsh@569";

      // It is used to provide template for writting connections,preparedstatement -->

       private JdbcTemplate jdbcTemplate;

     //  private StudentRowMapper studentRowMapper = new StudentRowMapper();

    //BEAN property is used to map student without implemnting rowmapper methode

       private RowMapper <Student> rowMapper =
               new BeanPropertyRowMapper<>(Student.class);

        public StudentRepository(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

      //  jdbc template --->>> update methode is used to create update or delete

        public void createstudent(Student student){

            String sql = """
                  INSERT INTO students (name, email, age)
                  VALUES (?,?,?)
                  """;

            int rowAffected = jdbcTemplate.update(sql,
                    student.getName(),student.getEmail(),student.getAge());

            if (rowAffected ==1) System.out.println("creation successfull");
            else System.out.println("creation unsuccessfull");
            }

        public  void updatestudent(Student student,long id){

            String sql = """
                 UPDATE students
                 SET name = ? ,
                     email= ?,
                     age = ?
                   WHERE id = ?
                 """;

            int rowaffected =jdbcTemplate.update(sql,
                    student.getName(),student.getEmail(),student.getAge(),id);

            if (rowaffected ==1) System.out.println("updation successfully");
            else System.out.println("updation failed");
        }


        public  void deletestudent (Long id){
            String sql = """
        DELETE from students  WHERE ID = ?
         """;
            int rowaffected = jdbcTemplate.update(sql,id);
            if (rowaffected ==1) System.out.println("deletion successfully");
            else System.out.println("deletion failed");
        }

//jdbc template--->>> query for object methode is used to get one row

        public Student getstudentbyid(Long id) {

            String sql = """
            SELECT id,name,email,age FROM students
             where  id
                        """;

            return jdbcTemplate.queryForObject(sql,
                    rowMapper,
                    id);
            }
            //jdbc template -->.>> query methode is used to get all student

        public List<Student> getallstudent (){

            String sql = """
            SELECT id,name,email,age FROM students
             """;

            List<Student> students = jdbcTemplate.query(
                    sql,rowMapper);

            return students;
    }
}
