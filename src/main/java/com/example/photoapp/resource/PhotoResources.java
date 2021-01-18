package com.example.photoapp.resource;

import com.example.photoapp.exceptions.InvalidTokenException;
import com.example.photoapp.model.FirebaseUser;
import com.example.photoapp.model.Photo;
import com.example.photoapp.service.FirebaseService;
import com.example.photoapp.service.PhotoService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/photos")
public class PhotoResources {
    @Autowired
    private PhotoService photoService;

    @Autowired
    FirebaseService firebaseService;

    @PostMapping("/photo")
    public Photo savePhoto(@RequestBody Photo photo, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, InvalidTokenException, FirebaseAuthException, InvalidTokenException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser != null){
            return photoService.savePhoto(photo);
        }
        return null;
    }

    @GetMapping("/all")
    public List<Photo> getPhoto(){
        return photoService.getPhoto();
    }

    @GetMapping("/find")
    public List<Photo> getPhotoById(@RequestParam(name = "photoId") String photoId){
        return photoService.getPhotoById(photoId);
    }

    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, InvalidTokenException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser != null){
            return photoService.updatePhoto(photo);
        }
        return null;
    }

    @DeleteMapping
    public void deletePhoto(@RequestParam(name = "photoId") String photoId, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, InvalidTokenException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser != null){
            photoService.deletePhoto(photoId);
        }
    }
}
