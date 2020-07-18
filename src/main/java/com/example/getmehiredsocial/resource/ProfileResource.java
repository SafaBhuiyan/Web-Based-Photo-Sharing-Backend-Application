package com.example.getmehiredsocial.resource;


import com.example.getmehiredsocial.model.Profile;
import com.example.getmehiredsocial.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")


public class ProfileResource {
    @Autowired
    private ProfileService profileService;
@GetMapping("/hello")
    public Profile getProfile(){
        return profileService.getProfile();
    }
}
