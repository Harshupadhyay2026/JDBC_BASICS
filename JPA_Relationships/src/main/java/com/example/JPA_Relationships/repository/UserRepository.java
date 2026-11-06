package com.example.JPA_Relationships.repository;

import com.example.JPA_Relationships.model.oneTOMany.Department;
import com.example.JPA_Relationships.model.onetoone.Profile;
import com.example.JPA_Relationships.model.onetoone.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


    @Repository
    public class UserRepository {
        @PersistenceContext
        private EntityManager entityManager;

        public User save(User profile) {
            entityManager.persist(profile);
            return profile;
        }
            public User getUserById (Long id){
                return  entityManager.find(User.class,id);
            }
        }

