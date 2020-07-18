package com.example.getmehiredsocial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidAlbumIdException.class)
    public ResponseEntity<?> customAlbumExceptionHandler(Exception ex, WebRequest request){
        return new ResponseEntity<> ( "error error: "+ ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidPhotoIdException.class)
    public ResponseEntity<?> customPhotoExceptionHandler(Exception ex, WebRequest request){
        return new ResponseEntity<> ( "error error error : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //@ExceptionHandler(Exception.class)
    //public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request){
        //return new ResponseEntity<> ( "error:", HttpStatus.BAD_REQUEST);
   //}


}
