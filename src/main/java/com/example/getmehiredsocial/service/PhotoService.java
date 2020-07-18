package com.example.getmehiredsocial.service;

import com.example.getmehiredsocial.exception.InvalidAlbumIdException;
import com.example.getmehiredsocial.model.Album;
import com.example.getmehiredsocial.model.Photo;
import com.example.getmehiredsocial.model.User;
import com.example.getmehiredsocial.repository.AlbumRepository;
import com.example.getmehiredsocial.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    CommentService commentService;
    @Autowired
    AlbumService albumService;
    @Autowired
  AlbumRepository albumRepository;


    public List<Photo> getPhotos() {
        return photoRepository.findAll();
    }

    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    public void edit(Photo photo) {
          photoRepository.save(photo);
    }

    public void delete(String photoId) {
        photoRepository.deleteById(photoId);
    }


    public void deleteByAlbumId(String albumId) {

        photoRepository.deleteByAlbumId(albumId);

    }

    //public Photo getSinglePhotoByAlbumId(String albumId) {
      //  return photoRepository.findByAlbumId(albumId);
    //}

    public boolean albumIdExists(String albumId){
        return photoRepository.existsByAlbumId(albumId);
    }

    public List<Photo> getPhotosForAlbum(String albumId) {
        return photoRepository.findByAlbumId(albumId);
    }
}

