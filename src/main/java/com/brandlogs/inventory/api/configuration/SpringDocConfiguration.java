package com.brandlogs.inventory.api.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class SpringDocConfiguration {
    @Bean
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Brandlogs Supermarket API")
                                .description("Web inventory API for a supermarket store")
                                .contact(
                                        new Contact()
                                                .name("Donald O. Oduol")
                                                .url("https://github.com/oduold")
                                )
                                .version("0.0.1")
                )
                ;
    }
}
