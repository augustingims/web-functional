package com.teamdevsolution.webfunctional.web.rest.handler;

import com.teamdevsolution.webfunctional.domain.Country;
import com.teamdevsolution.webfunctional.service.CountryService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Component
public class CountryHandler {

    private final CountryService countryService;

    public CountryHandler(CountryService countryService) {
        this.countryService = countryService;
    }

    public Mono<ServerResponse> getAllCountries(ServerRequest serverRequest){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(countryService.getAllCountries(), Country.class);
    }
    public Mono<ServerResponse> createCountry(ServerRequest serverRequest){
        final Mono<Country> countryMono = serverRequest.bodyToMono(Country.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(countryMono.flatMap(countryService::createCountry), Country.class));
    }
    public Mono<ServerResponse> getCountryById(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(countryService.getCountryById(id), Country.class);
    }

    public Mono<ServerResponse> updateCountry(ServerRequest serverRequest){
        final Mono<Country> countryMono = serverRequest.bodyToMono(Country.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(countryMono.flatMap(countryService::updateCountry), Country.class));
    }
    public Mono<ServerResponse> deleteCountry(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(countryService.deleteCountry(id), Void.class);
    }

}
