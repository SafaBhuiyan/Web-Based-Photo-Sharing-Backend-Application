package com.example.getmehiredsocial.resource;

import com.amazonaws.services.securitytoken.model.InvalidIdentityTokenException;
import com.example.getmehiredsocial.model.User;
import com.example.getmehiredsocial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Users")
public class UserResource {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void saveUser(@Valid @RequestBody User user){
        userService.save(user);
    }
    @PutMapping("/{userId}")
    public void editUser(@RequestBody User user,@PathVariable ("userId") String userId){
        user.setUserId(userId);
        userService.edit(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId){
        userService.delete(userId);
    }

    @GetMapping("/user authentication")
    public User me(@RequestParam("idToken") String idToken){
        if(userService.isValidUser(idToken)){
            String email = userService.fireBaseUser.getEmail();
            return userService.getByEmail(email);
        } else {
            throw new InvalidIdentityTokenException("Invalid Token is given, Please enter Valid Token......");
        }
    }
}
