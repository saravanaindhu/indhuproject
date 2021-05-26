package com.movie.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.movie.manager"})
public class MultiplexManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiplexManagerApplication.class, args);
	}

}
