package com.globallogic.spockExample.service.impl;

import com.globallogic.spockExample.dto.AlbumDTO;
import com.globallogic.spockExample.model.Album;
import com.globallogic.spockExample.repository.IAlbumRepo;
import com.globallogic.spockExample.service.IAlbumService;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Singleton
public class AlbumServiceImpl implements IAlbumService {

    protected final IAlbumRepo albumRepo;

    public AlbumServiceImpl(IAlbumRepo albumRepo) {
        this.albumRepo = albumRepo;
    }


    @Override

    public void createAlbum(AlbumDTO albumDTO) {
        albumRepo.save(AlbumDTO.fromDTOtoModel(albumDTO));
    }

    @Override
    public Optional<Album> getAlbum(@NotNull int albumID) {
        return albumRepo.findById(albumID);
    }

    @Override
    public List<Album> getAll() {
        return StreamSupport.stream(albumRepo.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public void updateAlbum(AlbumDTO albumDTO) {
        albumRepo.save(AlbumDTO.fromDTOtoModel(albumDTO));
    }

    @Override
    public void deleteAlbum(int albumID) {
        albumRepo.findById(albumID).ifPresent(albumRepo::delete);
    }
}
