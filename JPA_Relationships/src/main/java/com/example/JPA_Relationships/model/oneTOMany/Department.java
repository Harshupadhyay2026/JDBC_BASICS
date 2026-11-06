package com.example.JPA_Relationships.model.oneTOMany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @OneToMany(mappedBy = "department")  //department ki field of student class
    private List<Student> students = new ArrayList<>();

    //in this case if we do either one to many or many to one -->> in both case student and department table look same in dbeaver
    //combinig both the 1:N and N:1 we got bidirectional relationship

}
