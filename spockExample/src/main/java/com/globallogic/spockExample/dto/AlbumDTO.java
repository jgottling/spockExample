package com.globallogic.spockExample.dto;

import com.globallogic.spockExample.model.Album;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {

    private int id;
    private String title;
    private List<String> songs;
    private int stock;

    public static Album fromDTOtoModel(AlbumDTO albumDto) {

        return Album.builder().
                id(albumDto.getId()).
                title(albumDto.getTitle()).
                songs(albumDto.getSongs()).
                stock(albumDto.getStock()).
                build();
    }
}
