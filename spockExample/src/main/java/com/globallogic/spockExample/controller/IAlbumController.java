package com.globallogic.spockExample.controller;

import com.globallogic.spockExample.dto.AlbumDTO;
import com.globallogic.spockExample.model.Album;

import java.util.List;

public interface IAlbumController {

    void createAlbum(AlbumDTO albumDTO);

    Album getAlbum(String albumID);

    List<Album> getAll();

    void updateAlbum(AlbumDTO albumDTO);

    void deleteAlbum(String albumID);

}
