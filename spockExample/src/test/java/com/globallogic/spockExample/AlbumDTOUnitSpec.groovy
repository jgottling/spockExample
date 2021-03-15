package com.globallogic.spockExample

import com.globallogic.spockExample.dto.AlbumDTO
import spock.lang.Specification

class AlbumDTOUnitSpec extends Specification {

    //Class to be tested
    AlbumDTO albumDTO

    def setup() {
        albumDTO = new AlbumDTO()
    }

    def "setter testing with data tables"() {

        expect: "setter is working ok"
        albumDTO.setTitle(a)
        albumDTO.getTitle() == a

        where:
        a             | _
        "un titulo"   | _
        "otro titulo" | _
        
    }

    def "setter testing with data tables test 2"() {

        given: "set parameterized title"
        albumDTO.setTitle(a)

        expect: "setter is working ok"
        albumDTO.getTitle() == b

        where:
        a            || b
        "un titulo"   | "otro titulo"
        "otro titulo" | "un titulo"

    }
}
