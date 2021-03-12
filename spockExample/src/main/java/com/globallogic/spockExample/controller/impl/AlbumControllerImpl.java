package com.globallogic.spockExample.controller.impl;

import com.globallogic.spockExample.controller.IAlbumController;
import com.globallogic.spockExample.dto.AlbumDTO;
import com.globallogic.spockExample.service.IAlbumService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.reactivex.Single;

import java.util.List;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

@ExecuteOn(TaskExecutors.IO)
@Controller("/albums")
public class AlbumControllerImpl implements IAlbumController {

    protected final IAlbumService albumService;

    public AlbumControllerImpl(IAlbumService albumService) {
        this.albumService = albumService;
    }


    @Override
    @Post(uri = "/", produces = APPLICATION_JSON)
    public Single<HttpResponse<AlbumDTO>> createAlbum(@Body AlbumDTO albumDTO) {
        return Single.just(HttpResponse.created(albumService.createAlbum(albumDTO)));
    }

    @Override
    @Get(uri = "/{id}", produces = APPLICATION_JSON)
    public Single<HttpResponse<AlbumDTO>> getAlbum(@PathVariable String id) {

        return Single.just(HttpResponse.ok(albumService.getAlbum(Long.parseLong(id))));
    }

    @Override
    @Get(uri = "/", produces = APPLICATION_JSON)
    public Single<List<AlbumDTO>> getAll() {
        return Single.just(albumService.getAll());
    }

    @Override
    @Put(uri = "/", produces = APPLICATION_JSON)
    public Single<HttpResponse<AlbumDTO>> updateAlbum(@Body AlbumDTO albumDTO) {
        return Single.just(HttpResponse.ok(albumService.updateAlbum(albumDTO)));
    }

    @Override
    @Delete(uri = "/{id}", produces = APPLICATION_JSON)
    public Single<HttpResponse> deleteAlbum(@PathVariable String id) {
        albumService.deleteAlbum(Long.parseLong(id));
        return Single.just(HttpResponse.accepted());
    }

}
