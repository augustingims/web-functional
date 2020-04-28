package com.teamdevsolution.webfunctional;

import com.teamdevsolution.webfunctional.domain.Country;
import com.teamdevsolution.webfunctional.repository.CountryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableMongoAuditing
@EnableReactiveMongoRepositories
public class WebReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebReactiveApplication.class, args);
	}

}
