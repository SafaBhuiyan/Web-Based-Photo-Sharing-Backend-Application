package com.example.getmehiredsocial.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.Collection;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Comments")



public class Comment {
    @Id
    private String commentId;
    private String photoId;

    @Size(min = 1, max = 20)
    private String message;
    private String createdBy;
    private Date dateCreated;
}
