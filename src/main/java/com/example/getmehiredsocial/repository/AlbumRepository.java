package com.example.getmehiredsocial.repository;

import com.example.getmehiredsocial.model.Album;
import com.example.getmehiredsocial.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends MongoRepository<Album, String> {


    boolean existsByCoverPhotoUrl(String coverPhotoUrl);

    //Album findByAlbumId(String albumId);
}