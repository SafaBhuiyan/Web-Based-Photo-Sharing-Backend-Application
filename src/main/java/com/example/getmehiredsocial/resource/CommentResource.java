package com.example.getmehiredsocial.resource;


import com.example.getmehiredsocial.exception.InvalidPhotoIdException;
import com.example.getmehiredsocial.model.Comment;
import com.example.getmehiredsocial.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Comments")
public class CommentResource {
    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getCommnets(){
        return commentService.getComments();
    }

    @PostMapping
    public void saveComment(@RequestBody Comment comment){
        commentService.save(comment);
    }

    @PutMapping("/{commentId}")
    public void editComment(@RequestBody Comment comment, @PathVariable("commentId") String commentId)throws Exception{
        comment.setCommentId(commentId);
        commentService.edit(comment);
        throw new InvalidPhotoIdException("Invalid PhotoId given, Please enter a valid Photo Id");
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") String commentId){
        commentService.delete(commentId);
    }


}
