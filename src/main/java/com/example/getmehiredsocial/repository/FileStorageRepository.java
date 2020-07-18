package com.example.getmehiredsocial.repository;

import com.example.getmehiredsocial.model.FileStorage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileStorageRepository extends MongoRepository<FileStorage, String> {

}
