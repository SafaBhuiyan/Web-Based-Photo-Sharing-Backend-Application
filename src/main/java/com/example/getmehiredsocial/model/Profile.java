package com.example.getmehiredsocial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Profile {
    private String name;
    private int age;
    private Address address;
    private String phoneNumber;

}
