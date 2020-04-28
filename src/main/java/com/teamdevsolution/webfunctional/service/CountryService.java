package com.teamdevsolution.webfunctional.service;

import com.teamdevsolution.webfunctional.domain.Country;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryService {

    Flux<Country> getAllCountries();
    Mono<Country> createCountry(Country country);
    Mono<Country> getCountryById(String countryId);
    Mono<Country> updateCountry(Country country);
    Mono<Void> deleteCountry(String countryId);

}
