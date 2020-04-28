package com.teamdevsolution.webfunctional.web.rest.router;

import com.teamdevsolution.webfunctional.web.rest.handler.CountryHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Slf4j
@Configuration
public class CountryRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllCountries(CountryHandler countryHandler){
        return  route(GET("/countries").and(accept(MediaType.APPLICATION_JSON)),countryHandler::getAllCountries);
    }

    @Bean
    public RouterFunction<ServerResponse> createCountry(CountryHandler countryHandler){
        return  route(POST("/countries").and(accept(MediaType.APPLICATION_JSON)).and(contentType(MediaType.APPLICATION_JSON)),countryHandler::createCountry);
    }

    @Bean
    public RouterFunction<ServerResponse> getCountryById(CountryHandler countryHandler){
        return  route(GET("/countries/{id}").and(accept(MediaType.APPLICATION_JSON)),countryHandler::getCountryById);
    }

    @Bean
    public RouterFunction<ServerResponse> updateCountry(CountryHandler countryHandler){
        return  route(PUT("/countries").and(accept(MediaType.APPLICATION_JSON)).and(contentType(MediaType.APPLICATION_JSON)),countryHandler::updateCountry);
    }

    @Bean
    public RouterFunction<ServerResponse> deleteCountry(CountryHandler countryHandler){
        return  route(DELETE("/countries/{id}").and(contentType(MediaType.APPLICATION_JSON)),countryHandler::deleteCountry);
    }
}
