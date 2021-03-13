package com.globallogic.spockExample

import com.globallogic.spockExample.dto.AlbumDTO
import com.globallogic.spockExample.repository.IAlbumRepo
import com.globallogic.spockExample.service.impl.AlbumServiceImpl
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class AlbumIntegrationSpec extends Specification {
    /*
    Testear la creación del un álbum en la base de datos
    */

    //Class to be tested
    AlbumServiceImpl albumService

    @Inject
    IAlbumRepo albumRepo;

    //Test data
    private AlbumDTO sampleAlbumDTO

    def setup() {
        albumService = new AlbumServiceImpl(albumRepo)

        sampleAlbumDTO = AlbumDTO.builder().
                artist("Soda Stereo").
                title("Cancion Animal").
                songs(Arrays.asList("El septimo dia", "Cancion animal")).
                stock(10).
                build()

    }

    def "album service will get saved album from repository"() {

        when: "a service creates the sample album"
        albumService.createAlbum(sampleAlbumDTO)

        then: "the service can find the album previously created"
        albumService.getAlbumByTitle("Cancion Animal").getArtist() == "Soda Stereo"
    }
}
