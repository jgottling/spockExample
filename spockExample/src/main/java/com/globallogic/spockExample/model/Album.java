package com.globallogic.spockExample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "albums")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "album_title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "album_artist", nullable = false)
    private String artist;

    @Transient
    @Column(name = "album_songs", nullable = false)
    private List<String> songs;

    @Column(name = "album_stock", nullable = false)
    private int stock;

}
