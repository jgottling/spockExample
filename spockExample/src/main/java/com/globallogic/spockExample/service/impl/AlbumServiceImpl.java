package com.globallogic.spockExample.service.impl;

import com.globallogic.spockExample.dto.AlbumDTO;
import com.globallogic.spockExample.model.Album;
import com.globallogic.spockExample.service.IAlbumService;

import java.util.List;

public class AlbumServiceImpl implements IAlbumService {
    @Override
    public int createAlbum(AlbumDTO albumDTO) {
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
    public int updateAlbum(AlbumDTO albumDTO) {
        return 0;
    }

    @Override
    public int deleteAlbum(int AlbumID) {
        return 0;
    }
}
