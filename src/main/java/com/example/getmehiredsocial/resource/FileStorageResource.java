package com.example.getmehiredsocial.resource;


import com.amazonaws.services.s3.model.S3Object;
import com.example.getmehiredsocial.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/Files")
public class FileStorageResource {
    @Autowired
    private FileStorageService fileStorageService;

    @PutMapping
    public void uploadFile( @RequestParam("file")  MultipartFile file ) {
        try {
            fileStorageService.uploadFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @GetMapping
    public void viewFile(@RequestParam("key") String key, HttpServletResponse response) {
        S3Object object = fileStorageService.getFiles(key);
        try {
           response.setContentType(object.getObjectMetadata().getContentType());
           response.getOutputStream().write(object.getObjectContent().readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam("key") String key) {
        S3Object object = fileStorageService.getFiles(key);
        try {
            ByteArrayResource resource = new ByteArrayResource(object.getObjectContent().readAllBytes());
            String contentType = object.getObjectMetadata().getContentType();
            if (contentType == null){
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok()
                 .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION,  "attachment; filename =\""+key+"\"")
                    .body(resource);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @DeleteMapping
    public void deleteFile(@RequestParam("key") String key){
        fileStorageService.deleteFile(key);
    }

}
