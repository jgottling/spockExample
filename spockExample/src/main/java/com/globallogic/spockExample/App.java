package com.globallogic.spockExample;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Simple Albums CRUD",
                version = "1.0",
                description = "Simple CRUD for trying out Spock testing framework"
        )
)
public class App {
    public static void main(String[] args) {
        Micronaut.run(App.class, args);
    }
}
