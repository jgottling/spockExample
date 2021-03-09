package com.globallogic.spockExample.repository;

import com.globallogic.spockExample.model.Album;

import java.util.List;

public interface IAlbumRepo {

    int createAlbum(Album album);

    Album getAlbum(int albumID);

    List<Album> getAll();

    int updateAlbum(Album album);

    int deleteAlbum(int AlbumID);
}
