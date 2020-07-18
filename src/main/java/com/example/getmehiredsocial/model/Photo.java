package com.example.getmehiredsocial.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Photos")
public class Photo {
    @Id
    private String photoId;
    private String albumId;
    private String photoUrl;
    private String createdBy;
    private Date dateCreated;


}
