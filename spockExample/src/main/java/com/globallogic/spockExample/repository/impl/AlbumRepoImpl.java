package com.globallogic.spockExample.repository.impl;

import com.globallogic.spockExample.model.Album;
import com.globallogic.spockExample.repository.IAlbumRepo;

import java.util.List;

public class AlbumRepoImpl implements IAlbumRepo {
    @Override
    public int createAlbum(Album album) {
        return 0;
    }

    @Override
    public Album getAlbum(int albumID) {
        return null;
    }

    @Override
    public List<Album> getAll() {
        return null;
    }

    @Override
    public int updateAlbum(Album album) {
        return 0;
    }

    @Override
    public int deleteAlbum(int AlbumID) {
        return 0;
    }
}
