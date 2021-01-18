package com.example.photoapp.resource;

import com.example.photoapp.exceptions.InvalidTokenException;
import com.example.photoapp.model.Album;
import com.example.photoapp.model.FirebaseUser;
import com.example.photoapp.service.AlbumService;
import com.example.photoapp.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @Autowired
    FirebaseService firebaseService;

    @PostMapping("/album")
    public Album saveAlbum(@RequestBody Album album, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, InvalidTokenException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        album.setCreatedBy(firebaseUser);
        if(firebaseUser != null){
            return albumService.saveAlbum(album);
        }
        return null;
    }

    @GetMapping
    public List<Album> getAlbum(){
        return albumService.getAlbum();
    }

    @GetMapping("/find")
    public Album getAlbumById(@RequestParam(name = "albumId") String albumId){
        return albumService.getAlbumById(albumId);
    }

    @PutMapping
    public Album updateAlbum(@RequestBody Album album, @RequestParam(name = "albumId") String albumId, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, InvalidTokenException, FirebaseAuthException {

        if(!album.getCreatedBy().equals(firebaseService.authenticate(idToken).getEmail())){
            throw new InvalidTokenException();
        }
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        album.setCreatedBy(firebaseUser);

        if(firebaseUser != null){
            return albumService.updateAlbum(album);
        }
        return null;

    }

    @DeleteMapping
    public void deleteAlbum(@RequestParam(name = "albumId") String albumId, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, InvalidTokenException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser != null){
            albumService.deleteAlbum(albumId);
        }
    }
}
