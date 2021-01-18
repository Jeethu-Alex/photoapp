package com.example.photoapp.repository;

import com.example.photoapp.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PhotoRepository extends MongoRepository<Photo, String> {

    List<Photo> findAllById(String photoId);
}

