package com.example.photoapp.repository;

import com.example.photoapp.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, String> {
    Album findAllById(String albumId);
}
