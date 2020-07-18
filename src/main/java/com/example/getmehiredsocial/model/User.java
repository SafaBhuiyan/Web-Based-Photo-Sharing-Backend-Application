package com.example.getmehiredsocial.model;

import com.example.getmehiredsocial.validator.UniqueEmailAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Collection;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Users")
public class User {
    @Id
    private String userId;
    @NotBlank(message = "Username is mandatory")
    private String name;

    @UniqueEmailAddress
    private String email;
    private String profilePhotoUrl;
}

