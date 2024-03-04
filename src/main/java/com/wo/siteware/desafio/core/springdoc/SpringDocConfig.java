package com.wo.siteware.desafio.core.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Backend Siteware\n")
                        .version("v1")
                        .description("Rest API Siteware"));
    }
}
