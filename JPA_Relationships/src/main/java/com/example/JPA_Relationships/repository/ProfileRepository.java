package com.example.JPA_Relationships.repository;

import com.example.JPA_Relationships.model.onetoone.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {
    @PersistenceContext
   private EntityManager entityManager;

    public Profile save(Profile profile){
         entityManager.persist(profile);
         return  profile;
    }

}
