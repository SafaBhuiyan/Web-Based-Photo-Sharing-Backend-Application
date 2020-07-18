package com.example.getmehiredsocial.service;

import com.example.getmehiredsocial.model.Profile;
import com.example.getmehiredsocial.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    public Profile getProfile(){
        return profileRepository.getProfile();
    }

}
