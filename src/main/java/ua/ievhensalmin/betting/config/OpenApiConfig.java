package ua.ievhensalmin.betting.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI bettingApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Betting API")
                        .description("Sports betting event processing system")
                        .version("v1.0"));
    }
}