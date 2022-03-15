package team.bahor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import team.bahor.property.OpenApiProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import team.bahor.properties.ServerProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        OpenApiProperty.class
})
@OpenAPIDefinition
@EnableConfigurationProperties(
        ServerProperties.class
)
public class BoomAcademyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoomAcademyApplication.class, args);
    }


}
