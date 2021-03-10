package com.globallogic.spockExample.repository;

import com.globallogic.spockExample.model.Album;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface IAlbumRepo extends CrudRepository<Album, Integer> {

}
