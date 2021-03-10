package com.globallogic.spockExample.repository.impl;

import com.globallogic.spockExample.model.Album;
import com.globallogic.spockExample.repository.IAlbumRepo;
import io.micronaut.transaction.annotation.ReadOnly;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
public class AlbumRepoImpl implements IAlbumRepo {

    private final EntityManager entityManager;

    public AlbumRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private Album findByID(int albumID) {
        //TODO throw exception album not found
        return entityManager.find(Album.class, albumID);
    }

    @Override
    @Transactional
    public void createAlbum(Album album) {
        entityManager.persist(album);
    }

    @Override
    @ReadOnly
    public Album getAlbum(int albumID) {
        return findByID(albumID);
    }

    @Override
    @ReadOnly
    public List<Album> getAll() {
        String qlString = "SELECT a FROM albums as a";
        TypedQuery<Album> query = entityManager.createQuery(qlString, Album.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateAlbum(Album album) {

        Album albumOld = entityManager.find(Album.class, album.getId());

        if (albumOld != null) {
            albumOld.setSongs(album.getSongs());
            albumOld.setStock(album.getStock());
            albumOld.setTitle(album.getTitle());
            entityManager.persist(albumOld);
        }

    }

    @Override
    @Transactional
    public void deleteAlbum(int albumID) {
        entityManager.remove(findByID(albumID));
    }
}
