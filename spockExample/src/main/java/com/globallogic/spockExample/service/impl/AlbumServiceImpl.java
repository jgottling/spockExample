package com.globallogic.spockExample.service.impl;

import com.globallogic.spockExample.dto.AlbumDTO;
import com.globallogic.spockExample.model.Album;
import com.globallogic.spockExample.repository.IAlbumRepo;
import com.globallogic.spockExample.service.IAlbumService;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Singleton
public class AlbumServiceImpl implements IAlbumService {


    protected final IAlbumRepo albumRepo;

    public AlbumServiceImpl(IAlbumRepo albumRepo) {
        this.albumRepo = albumRepo;
    }

    @Override
    public AlbumDTO createAlbum(AlbumDTO albumDTO) {
        albumRepo.save(AlbumDTO.fromDTOtoModel(albumDTO));

        return Album.modelToDTO(albumRepo.findByTitle(albumDTO.getTitle()).get());
    }

    @Override
    public AlbumDTO getAlbum(@NotNull long albumID) {
        try {
            return Album.modelToDTO(albumRepo.findById(albumID).get());
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public AlbumDTO getAlbumByTitle(@NotNull String albumTitle) {

        return Album.modelToDTO(albumRepo.findByTitle(albumTitle).get());
    }

    @Override
    public List<AlbumDTO> getAll() {
        Iterable<Album> allAlbums = albumRepo.findAll();
        ArrayList<AlbumDTO> albums = new ArrayList<>();
        for (Album album :
                allAlbums
        ) {
            albums.add(Album.modelToDTO(album));
        }

        return albums;
    }

    @Override
    public AlbumDTO updateAlbum(AlbumDTO albumDTO) {
        albumRepo.save(AlbumDTO.fromDTOtoModel(albumDTO));

        return albumDTO;
    }

    @Override
    public void deleteAlbum(long albumID) {
        albumRepo.findById(albumID).ifPresent(albumRepo::delete);
    }
}
