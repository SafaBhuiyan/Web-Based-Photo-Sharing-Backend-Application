package com.example.getmehiredsocial.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.example.getmehiredsocial.model.FileStorage;
import com.example.getmehiredsocial.repository.FileStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileStorageService {
    @Autowired
    FileStorageRepository fileStorageRepository;


    @Value("${aws.s3.accessKey}")
    private String awsAccessKey;
    @Value("${aws.s3.secretKey}")
    private String awsSecretKey;

    public void uploadFile( MultipartFile multipartFile) throws IOException {
        ObjectMetadata data = new ObjectMetadata();
        data.setContentType(multipartFile.getContentType());
        data.setContentLength(multipartFile.getSize());
        BasicAWSCredentials creds = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();
        PutObjectResult objectResult = s3client.putObject("backend-class", "images/"+multipartFile.getOriginalFilename(), multipartFile.getInputStream(), data);
    }



    public S3Object getFiles(String key){
        BasicAWSCredentials creds = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();
        return s3client.getObject("backend-class", key);
    }

    public void deleteFile(String key) {
        BasicAWSCredentials creds = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();
        s3client.deleteObject("backend-class", key);
    }

    //public void save(File files) {
      //  fileStorageRepository.save(files);
    //}
}


