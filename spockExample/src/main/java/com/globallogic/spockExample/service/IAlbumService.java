package com.globallogic.spockExample.service;

import com.globallogic.spockExample.dto.AlbumDTO;
import com.globallogic.spockExample.model.Album;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface IAlbumService {
    void createAlbum(@NotNull AlbumDTO albumDTO);

    Optional<Album> getAlbum(@NotNull int albumID);

    List<Album> getAll();

    void updateAlbum(@NotNull AlbumDTO albumDTO);

    void deleteAlbum(@NotNull int albumID);
}
