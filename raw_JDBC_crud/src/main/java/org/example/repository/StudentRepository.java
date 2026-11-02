package org.example.repository;

import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/Student_jdbc?allowPublicKeyRetrieval=true&useSSL=false";
    String username = "root";
    String password = "Harsh@569";

public void createuser(Student student){

    String sql = """
                  INSERT INTO students (name, email, age)
                  VALUES (?,?,?)
                  """;

      try(
       Connection connection = DriverManager.getConnection(url,username,password);

       PreparedStatement preparedStatement =
               connection.prepareStatement(sql);
      ){
          preparedStatement.setString(1, student.getName());
          preparedStatement.setString(2, student.getEmail());
          preparedStatement.setInt(3, student.getAge());

          int rowAffected = preparedStatement.executeUpdate();

          if (rowAffected ==1) System.out.println("creation successfull");
          else System.out.println("creation unsuccessfull");
    }
      catch (
    SQLException e){
        System.out.println("DataBase connection failed");
        e.printStackTrace();
    }
    //      Statement statement = connection.createStatement();

//        String sql = "Insert INTO students(name,email,age) " +
//                "VALUES ('Aditya','adi@gmail.com' , '26' )";
//
//        int result = statement.executeUpdate(sql);
//
//        if (result ==1) System.out.println("creation successfully");
//        else System.out.println("creation failed");
}

public  void UpdateUser(Student student,long id){

    String sql = """
                 UPDATE students
                 SET name = ? ,
                     email= ?,
                     age = ?
                   WHERE id = ?
                 """;
    try(
        Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ){

        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getEmail());
        preparedStatement.setInt(3, student.getAge());
        preparedStatement.setLong(4, id);

        int rowaffected =preparedStatement.executeUpdate();

        if (rowaffected ==1) System.out.println("updation successfully");
        else System.out.println("updation failed");

    }
    catch (SQLException e){
        System.out.println("DataBase connection failed");
        e.printStackTrace();
    }
}
public  void DeleteUser (Long id){
    String sql = """
  DELETE from students  WHERE ID = ?
""";

    try(
        Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement =
                connection.prepareStatement(sql);
    ) {
        preparedStatement.setLong(1, id);

        int rowaffected = preparedStatement.executeUpdate();

        if (rowaffected ==1) System.out.println("deletion successfully");
        else System.out.println("deletion failed");

    }
    catch (
            SQLException e){
         System.out.println("DataBase connection failed");
         e.printStackTrace();
    }
}
public void getuserbyid(Long id){

    String sql = """
            SELECT id,name,email,age FROM students
             where  id = ?
             """;

    try(
        Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement =
                connection.prepareStatement(sql);
    ){

        preparedStatement.setLong(1,id);

       try(ResultSet resultSet = preparedStatement.executeQuery()){
        if(resultSet.next()){
            Student student = maprow(resultSet);
            System.out.println(student);
       }
        }
    }
    catch (
            SQLException e){
        System.out.println("DataBase connection failed");
        e.printStackTrace();
    }}

    public void  getStudent (){

            String sql = """
            SELECT id,name,email,age FROM students
             """;

            try(Connection connection = DriverManager.getConnection(url,username,password);
                    PreparedStatement preparedStatement =
                            connection.prepareStatement(sql);
            ){

                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    List<Student> studentList = new ArrayList<>();

                    while(resultSet.next()){
                        Student student = maprow(resultSet);
                        studentList.add(student);
                        System.out.println(student);
                    }
                }
            }
            catch (
                    SQLException e){
                System.out.println("DataBase connection failed");
                e.printStackTrace();
            }}

    private Student maprow (ResultSet resultSet ) throws SQLException{
        Student student = new Student();

        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));
        student.setEmail(resultSet.getString("email"));
        return  student;

    }

    public void CompleteCRUD(){

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("DataBase connected successfully");

            Statement statement = connection.createStatement();

            String sql = "SELECT id,name,email,age " +
                    "FROM  students where id =2 ";

            boolean result = statement.execute(sql);

            if (result) {
                ResultSet resultSet = statement.getResultSet();
            }
            else{
                int RowAffected = statement.getUpdateCount();
            }

            connection.close();
        }
        catch (
                SQLException e){
            System.out.println("DataBase connection failed");
            e.printStackTrace();
        }
    }
}



