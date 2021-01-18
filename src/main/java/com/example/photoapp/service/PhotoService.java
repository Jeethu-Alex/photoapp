package com.example.photoapp.service;

import com.example.photoapp.model.Photo;
import com.example.photoapp.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public Photo savePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public List<Photo> getPhoto(){
        return photoRepository.findAll();
    }

    public List<Photo> getPhotoById(String photoId) {
        return photoRepository.findAllById(photoId);
    }

    public Photo updatePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public void deletePhoto(String photoId) {
        photoRepository.deleteById(photoId);
    }
}
