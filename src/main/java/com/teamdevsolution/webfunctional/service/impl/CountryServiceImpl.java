package com.teamdevsolution.webfunctional.service.impl;

import com.teamdevsolution.webfunctional.domain.Country;
import com.teamdevsolution.webfunctional.repository.CountryRepository;
import com.teamdevsolution.webfunctional.service.CountryService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Flux<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Mono<Country> createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Mono<Country> getCountryById(String countryId) {
        return countryRepository.findById(countryId);
    }

    @Override
    public Mono<Country> updateCountry(Country country) {
        return countryRepository.findById(country.getId())
                .flatMap(existingCountry -> {
                    existingCountry.setName(country.getName());
                    existingCountry.setCode(country.getCode());
                    existingCountry.setFlag(country.getFlag());
                    return countryRepository.save(existingCountry);
                });
    }

    @Override
    public Mono<Void> deleteCountry(String countryId) {
        return countryRepository.findById(countryId)
                .flatMap(countryRepository::delete);
    }
}
