package com.example.getmehiredsocial.service;

import com.example.getmehiredsocial.model.FireBaseUser;
import com.example.getmehiredsocial.model.User;
import com.example.getmehiredsocial.repository.UserRepository;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    public FireBaseUser fireBaseUser;
    @Autowired
    UserRepository userRepository;
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void edit(User user) {
        userRepository.save(user);
    }

    public void delete(String userId) {
        userRepository.deleteById(userId);
    }

    public boolean emailExist(String email) {
         return userRepository.existsByEmail(email);
    }

    public boolean isValidUser(String idToken){
    try {
        String uid = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
        String name = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getName();
        String email = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getEmail();
        if(!StringUtils.isEmpty(uid)&& !StringUtils.isEmpty(email)){
            FireBaseUser fireBaseUser = new FireBaseUser(uid, name, email);
            this.fireBaseUser = fireBaseUser;
            return true;
        } else {
            return false;
        }
    } catch (InterruptedException| ExecutionException e){
        this.fireBaseUser = null;
        return false;
    }

    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
