package com.globallogic.spockExample

import com.globallogic.spockExample.controller.impl.AlbumControllerImpl
import com.globallogic.spockExample.dto.AlbumDTO
import com.globallogic.spockExample.repository.IAlbumRepo
import com.globallogic.spockExample.service.impl.AlbumServiceImpl
import groovyx.net.http.RESTClient
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import org.apache.commons.lang3.StringUtils
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class AlbumAcceptanceSpec extends Specification {
    /*
        Rest client perfoms update on album then a get of the same album reflects the change
    */

    //Class to be tested
    AlbumControllerImpl albumController

    //Dependencies (will be injected)
    @Inject
    AlbumServiceImpl albumService

    @Inject
    IAlbumRepo albumRepo

    //Test data
    AlbumDTO sampleAlbum
    def url = "http://localhost:8080/albums"
    RESTClient restClient

    def setup() {

        restClient = new RESTClient(url)

        sampleAlbum = AlbumDTO.builder().
                id(1).
                artist("Soda Stereo").
                title("Cancion Animal").
                songs(Arrays.asList("El septimo dia", "Cancion animal")).
                stock(10).
                build()

        restClient.post(path: '/', body: sampleAlbum)
    }

    def "should return an updated album"() {
        sampleAlbum.setTitle("titulo cambiado")

        given: "user updates an album"
        restClient.put(path: '/', query: sampleAlbum)

        when: "a service gets the sample album"
        AlbumDTO album = restClient.get(path: '/1', body: sampleAlbum) as AlbumDTO

        then: "the service returns the sample album with id 1"
        StringUtils.equals(album.getTitle(), "titulo cambiado")
    }

}
