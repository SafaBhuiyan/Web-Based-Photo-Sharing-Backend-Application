package com.example.getmehiredsocial.repository;

import com.example.getmehiredsocial.model.Address;
import com.example.getmehiredsocial.model.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {
    public Profile getProfile(){
        Profile profile = new Profile("Shamsad", 35, new Address("Tokyo", "Japan"), "256848");
        return profile;
    }
}
