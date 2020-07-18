package com.example.getmehiredsocial.resource;

import com.example.getmehiredsocial.exception.InvalidAlbumIdException;
import com.example.getmehiredsocial.model.Album;
import com.example.getmehiredsocial.model.Photo;
import com.example.getmehiredsocial.service.AlbumService;
import com.example.getmehiredsocial.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Albums")
public class AlbumResource {
    @Autowired
    AlbumService albumService;
    @Autowired
    PhotoService photoService;

    @GetMapping
    public List<Album> getMyAlbums(){
        return albumService.getAlbums();
    }

    @GetMapping("/{albumId}")
    public List<Photo> getPhotosForAlbums(@PathVariable("albumId") String albumId){
        return photoService.getPhotosForAlbum(albumId);
    }

    @PostMapping
    public void saveAlbum(@Valid @RequestBody Album album){
        albumService.save(album);
    }

    @PutMapping("/{albumId}")
    public void editAlbum(@RequestBody Album album,@PathVariable("albumId") String albumId){
        album.setAlbumId(albumId);
        albumService.edit(album);

    }
    @DeleteMapping("/{albumId}")
    public void deleteAlbumWithPhotosComments(@PathVariable("albumId") String albumId){
        albumService.delete(albumId);
    }

    @DeleteMapping("/dOnlyAlbums/{albumId}")
    public void deleteAlbumOnly(@PathVariable("albumId") String albumId){
        albumService.deleteById(albumId);

    }


}

