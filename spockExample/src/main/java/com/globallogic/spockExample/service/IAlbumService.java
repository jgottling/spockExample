package com.globallogic.spockExample.service;

import com.globallogic.spockExample.dto.AlbumDTO;
import com.globallogic.spockExample.model.Album;

import java.util.List;

public interface IAlbumService {
    int createAlbum(AlbumDTO albumDTO);

    Album getAlbum(int albumID);

    List<Album> getAll();

    int updateAlbum(AlbumDTO albumDTO);

    int deleteAlbum(int AlbumID);
}
