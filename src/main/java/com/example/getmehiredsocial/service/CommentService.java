package com.example.getmehiredsocial.service;

import com.example.getmehiredsocial.model.Comment;
import com.example.getmehiredsocial.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void edit(Comment comment) {
        commentRepository.save(comment);
    }

    public void delete(String commentId) {
        commentRepository.deleteById(commentId);
    }
    //public void deleteByPhotoId(String photoId){
    //  commentRepository.deleteByPhotoId(photoId);
    //}

    public void deleteCommentByPhotoId(String photoId) {
       commentRepository.deleteByPhotoId(photoId);
    }
}


