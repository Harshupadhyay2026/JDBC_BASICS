package com.example.JPA_Relationships.model.manytomany;

import com.example.JPA_Relationships.model.onetoone.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
    @Setter
    @NoArgsConstructor
    @Entity
    public class Student2 {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private  String name;

        @ManyToMany
        @JoinTable(
                name = "student_course",
                joinColumns = @JoinColumn (name = "student_id"),
                inverseJoinColumns=@JoinColumn(name = "course_id")
        )
        private List<Courses> courses = new ArrayList<>();
}
