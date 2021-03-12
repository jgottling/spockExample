package com.globallogic.spockExample.controller;

import com.globallogic.spockExample.dto.AlbumDTO;
import io.micronaut.http.HttpResponse;
import io.reactivex.Single;

import java.util.List;

public interface IAlbumController {

    Single<HttpResponse<AlbumDTO>> createAlbum(AlbumDTO albumDTO);

    Single<HttpResponse<AlbumDTO>> getAlbum(String albumID);

    Single<List<AlbumDTO>> getAll();

    Single<HttpResponse<AlbumDTO>> updateAlbum(AlbumDTO albumDTO);

    Single<HttpResponse> deleteAlbum(String albumID);

}
