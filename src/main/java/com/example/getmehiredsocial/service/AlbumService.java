package com.example.getmehiredsocial.service;

import com.example.getmehiredsocial.exception.InvalidPhotoIdException;
import com.example.getmehiredsocial.model.Album;
import com.example.getmehiredsocial.model.Photo;
import com.example.getmehiredsocial.repository.AlbumRepository;
import com.example.getmehiredsocial.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;
@Autowired
PhotoService photoService;
@Autowired
CommentService commentService;
@Autowired
PhotoRepository photoRepository;


    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    public void save(Album album) {
        albumRepository.save(album);

    }


    public void edit(Album album) {
        albumRepository.save(album);
    }

    public void delete(String albumId) {

        for(Photo p:photoService.getPhotosForAlbum(albumId)) {

            commentService.deleteCommentByPhotoId(p.getPhotoId());
        }
        photoService.deleteByAlbumId(albumId);
        albumRepository.deleteById(albumId);


    }

    public void deleteById(String albumId) {
        albumRepository.deleteById(albumId);
    }


    public boolean coverPhotoUrlExists(String coverPhotoUrl) {
      return albumRepository.existsByCoverPhotoUrl(coverPhotoUrl);
    }


}