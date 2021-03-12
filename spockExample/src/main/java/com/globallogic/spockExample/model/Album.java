package com.globallogic.spockExample.model;

import com.globallogic.spockExample.dto.AlbumDTO;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@MappedEntity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue
    private long id;

    @MappedProperty
    private String title;
    private String artist;

    @ElementCollection
    private List<String> songs;
    private int stock;

    public static AlbumDTO modelToDTO(Album album) {

        return AlbumDTO.builder().
                id(album.getId()).
                title(album.getTitle()).
                artist(album.getArtist()).
                songs(album.getSongs()).
                stock(album.getStock()).
                build();
    }
}
