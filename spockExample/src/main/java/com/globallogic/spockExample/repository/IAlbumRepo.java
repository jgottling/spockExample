package com.globallogic.spockExample.repository;

import com.globallogic.spockExample.model.Album;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface IAlbumRepo extends CrudRepository<Album, Long> {

    @Executable
    Optional<Album> findByTitle(String title);
}
