package com.example.getmehiredsocial.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FireBaseUser {
    private String uid;
    private String name;
    private String email;

}
