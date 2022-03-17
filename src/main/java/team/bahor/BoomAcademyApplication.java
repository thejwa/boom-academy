package team.bahor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import team.bahor.property.OpenApiProperty;

@SpringBootApplication
@EnableConfigurationProperties({
        OpenApiProperty.class
})
@OpenAPIDefinition
public class BoomAcademyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoomAcademyApplication.class, args);
    }

}
