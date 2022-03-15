package team.bahor.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.bahor.property.OpenApiProperty;

import java.util.List;

@Configuration
@ConditionalOnProperty(name = "springdoc.swagger-ui.enabled", havingValue = "true", matchIfMissing = true)
public class OpenApiConfigurer {

    private static final String BEARER_FORMAT = "JWT";
    private static final String SCHEME = "Bearer";
    private static final String SECURITY_SCHEME = "Security Scheme";
    private final OpenApiProperty openApiProperty;

    public OpenApiConfigurer(OpenApiProperty openApiProperty) {
        this.openApiProperty = openApiProperty;
    }

    @Bean
    public OpenAPI api() {

        return new OpenAPI()
                .schemaRequirement(SECURITY_SCHEME, getSecurityScheme())
                .security(getSecurityRequirement())
                .info(info());

    }

    private List<SecurityRequirement> getSecurityRequirement() {
        SecurityRequirement securityRequirement = new SecurityRequirement();
        securityRequirement.addList(SECURITY_SCHEME);
        return List.of(securityRequirement);
    }

    private SecurityScheme getSecurityScheme() {
        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.bearerFormat(BEARER_FORMAT)
                .type(SecurityScheme.Type.HTTP)
                .in(SecurityScheme.In.HEADER)
                .scheme(SCHEME);
        return securityScheme;
    }

    private Info info() {
        return new Info()
                .title(openApiProperty.getTitle())
                .version(openApiProperty.getVersion())
                .termsOfService(openApiProperty.getTermOfService())
                .description(openApiProperty.getDescription())
                .contact(new Contact()
                        .name(openApiProperty.getContactName())
                        .email(openApiProperty.getContactEmail())
                        .url(openApiProperty.getContactUrl())
                )
                .license(new License()
                        .name(openApiProperty.getLicenseName())
                        .url(openApiProperty.getLicenseUrl())
                );
    }

}
