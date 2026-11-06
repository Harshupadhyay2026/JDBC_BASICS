package com.example.JPA_Relationships.service;

import com.example.JPA_Relationships.model.oneTOMany.Department;
import com.example.JPA_Relationships.model.oneTOMany.Student;
import com.example.JPA_Relationships.model.onetoone.Profile;
import com.example.JPA_Relationships.model.onetoone.User;
import com.example.JPA_Relationships.repository.ProfileRepository;
import com.example.JPA_Relationships.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private ProfileRepository profileRepository;
    private UserRepository userRepository;

    public ProfileService(ProfileRepository profileRepository,
                          UserRepository userRepository){
        this.profileRepository=profileRepository;
        this.userRepository = userRepository;
    }
    @Transactional
    public void create(Profile profile , Long userId) {
        User user =
                userRepository.getUserById(userId);

        profile.setUser(user);

        //adding each student in department

        profileRepository.save(profile);
    }



    @Transactional
    public void create(Profile profile,String UserName) {

       User user = new User();
       user.setName(UserName);
       userRepository.save(user);

        profile.setUser(user); //connecting database of user with profile

        profileRepository.save(profile);
    }
}
