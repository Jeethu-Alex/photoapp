package com.example.photoapp.service;

import com.example.photoapp.model.Album;
import com.example.photoapp.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> getAlbum(){
        return albumRepository.findAll();
    }

    public Album getAlbumById(String albumId) {
        return albumRepository.findAllById(albumId);
    }

    public Album updateAlbum(Album album) {
        return albumRepository.save(album);
    }

    public void deleteAlbum(String albumId) {
        albumRepository.deleteById(albumId);
    }
}
