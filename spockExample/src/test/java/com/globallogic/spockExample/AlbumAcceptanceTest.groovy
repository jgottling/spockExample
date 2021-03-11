package com.globallogic.spockExample

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

@MicronautTest
class AlbumAcceptanceTest extends Specification {

    //Fixture Methods
    def setupSpec() {}    // runs once -  before the first feature method
    def setup() {}        // runs before every feature method
    def cleanup() {}      // runs after every feature method
    def cleanupSpec() {}  // runs once -  after the last feature method
    
}
