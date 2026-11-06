package com.example.JPA_Relationships.controller;

import com.example.JPA_Relationships.model.oneTOMany.Student;
import com.example.JPA_Relationships.model.onetoone.Profile;
import com.example.JPA_Relationships.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<String> create(
            @RequestBody Profile profile,
            @PathVariable Long userId) {

        profileService.create(profile, userId);
        return ResponseEntity.ok("Done");
    }


    @PostMapping("/putUser")
    public ResponseEntity<String> create(
            @RequestParam String UserName,
            @RequestBody Profile request
            ){

         profileService.create(request,UserName);

         return ResponseEntity.ok("Done");
    }


}
