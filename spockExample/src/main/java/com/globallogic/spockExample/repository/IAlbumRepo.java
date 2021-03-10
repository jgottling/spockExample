package com.globallogic.spockExample.repository;

import com.globallogic.spockExample.model.Album;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface IAlbumRepo {

    void createAlbum(@NotNull Album album);

    Album getAlbum(@NotNull int albumID);

    List<Album> getAll();

    void updateAlbum(@NotNull Album album);

    void deleteAlbum(@NotNull int albumID);
}
