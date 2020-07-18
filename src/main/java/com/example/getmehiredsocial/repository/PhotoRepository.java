package com.example.getmehiredsocial.repository;

import com.example.getmehiredsocial.model.Album;
import com.example.getmehiredsocial.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhotoRepository extends MongoRepository<Photo,String> {


    void deleteByAlbumId(String albumId);

    List<Photo> findByAlbumId(String albumId);


    Photo findByPhotoId(String photoId);

    boolean existsByAlbumId(String albumId);
}

