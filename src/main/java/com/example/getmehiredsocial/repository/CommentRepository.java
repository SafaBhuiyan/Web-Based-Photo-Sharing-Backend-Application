package com.example.getmehiredsocial.repository;

import com.example.getmehiredsocial.model.Comment;
import com.example.getmehiredsocial.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    void deleteByPhotoId(String photoId);
}
