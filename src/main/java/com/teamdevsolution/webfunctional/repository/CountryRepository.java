package com.teamdevsolution.webfunctional.repository;

import com.teamdevsolution.webfunctional.domain.Country;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends ReactiveMongoRepository<Country, String> {

}
