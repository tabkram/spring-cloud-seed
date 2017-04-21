package com.talan.labs.seed.msa.service.acme.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    /** The title for the spring boot service to be displayed on swagger UI. */
    @Value("${swagger.title}")
    private String title;

    /** The description of the spring boot service. */
    @Value("${swagger.description}")
    private String description;

    /** The version of the service. */
    @Value("${swagger.version}")
    private String version;

    /** The terms of service url for the service if applicable. */
    @Value("${swagger.termsOfServiceUrl}")
    private String termsOfServiceUrl;

    /** The contact name for the service. */
    @Value("${swagger.contact.name}")
    private String contactName;

    /** The contact url for the service. */
    @Value("${swagger.contact.url}")
    private String contactURL;

    /** The contact email for the service. */
    @Value("${swagger.contact.email}")
    private String contactEmail;

    /** The license for the service if applicable. */
    @Value("${swagger.license}")
    private String license;

    /** The license url for the service if applicable. */
    @Value("${swagger.licenseUrl}")
    private String licenseURL;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/v.*"))
                .build()
                .apiInfo(apiInfo());
    }

/*
    private Predicate<String> paths() {
        return Predicates.not(PathSelectors.regex("/basic-error-controller.*"));
    }
*/

    /**
     * This method will return the API info object to swagger which will in turn display the information on the swagger UI.
     *
     * @return the API information
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(title, description, version, termsOfServiceUrl, new Contact(contactName, contactURL, contactEmail), license, licenseURL);
    }
}