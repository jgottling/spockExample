package com.globallogic.spockExample.service;

import com.globallogic.spockExample.dto.AlbumDTO;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface IAlbumService {
    AlbumDTO createAlbum(@NotNull AlbumDTO albumDTO);

    AlbumDTO getAlbum(@NotNull long albumID);

    AlbumDTO getAlbumByTitle(@NotNull String albumTitle);

    List<AlbumDTO> getAll();

    AlbumDTO updateAlbum(@NotNull AlbumDTO albumDTO);

    void deleteAlbum(@NotNull long albumID);


}
