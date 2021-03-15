package com.globallogic.spockExample

import com.globallogic.spockExample.model.Album
import com.globallogic.spockExample.repository.IAlbumRepo
import com.globallogic.spockExample.service.impl.AlbumServiceImpl
import spock.lang.Specification

class AlbumServiceUnitSpec extends Specification {

    /*
    Test get con el repositorio mockeado
    */

    //Class to be tested
    AlbumServiceImpl albumService;

    //Dependencies (will be mocked)
    IAlbumRepo albumRepo;

    //Test data
    Album sampleAlbum;

    def setup() {
        albumRepo = Stub(IAlbumRepo)
        albumService = new AlbumServiceImpl(albumRepo)

        sampleAlbum = Album.builder().
                id(1).
                artist("Soda Stereo").
                title("Cancion Animal").
                songs(Arrays.asList("El septimo dia", "Cancion animal")).
                stock(10).
                build()
    }

    def "album service will get saved album from repository"() {

        given: "repository returns sampleAlbum"
        albumRepo.findById(_) >> Optional.of(sampleAlbum)

        when: "a service gets the sample album"
        def album = albumService.getAlbum(1)

        then: "the service returns the sample album with id 1"
        album.getId() == 1
    }
}
