package com.globallogic.spockExample

import com.globallogic.spockExample.model.Album
import com.globallogic.spockExample.repository.IAlbumRepo
import com.globallogic.spockExample.service.impl.AlbumServiceImpl
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

@MicronautTest
class AlbumServiceUnitTest extends Specification {

    /*
    Testear el get de ese álbum con el repositorio mockeado
    */

    //Class to be tested
    private AlbumServiceImpl albumService;

    //Dependencies (will be mocked)
    private IAlbumRepo albumRepo;

    //Test data
    private Album sampleAlbum;

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

        albumRepo.findById(_) >> Optional.of(sampleAlbum)

    }

    def "album service will get saved album from repository"() {

        when: "a service gets the sample album"
        def album = albumService.getAlbum(1)

        then: "the service returns the sample album with id 1"
        album.get().getId() == 1
    }

}
