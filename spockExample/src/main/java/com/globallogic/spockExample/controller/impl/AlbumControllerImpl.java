package com.globallogic.spockExample.controller.impl;

import com.globallogic.spockExample.controller.IAlbumController;
import com.globallogic.spockExample.dto.AlbumDTO;
import com.globallogic.spockExample.model.Album;
import com.globallogic.spockExample.service.IAlbumService;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.util.List;
import java.util.Optional;

@ExecuteOn(TaskExecutors.IO)
@Controller("/albums")
public class AlbumControllerImpl implements IAlbumController {

    protected final IAlbumService albumService;

    public AlbumControllerImpl(IAlbumService albumService) {
        this.albumService = albumService;
    }


    @Override
    @Post("/")
    public void createAlbum(@Body AlbumDTO albumDTO) {
        albumService.createAlbum(albumDTO);
    }

    @Override
    @Get("/{id}")
    public Album getAlbum(@PathVariable String id) {

        Optional<Album> album = albumService.getAlbum(Integer.parseInt(id));

        return album.orElse(null);
    }

    @Override
    @Get("/")
    public List<Album> getAll() {
        return albumService.getAll();
    }

    @Override
    @Put("/")
    public void updateAlbum(@Body AlbumDTO albumDTO) {
        albumService.updateAlbum(albumDTO);
    }

    @Override
    @Delete("/{id}")
    public void deleteAlbum(@PathVariable String id) {
        albumService.deleteAlbum(Integer.parseInt(id));
    }
}
