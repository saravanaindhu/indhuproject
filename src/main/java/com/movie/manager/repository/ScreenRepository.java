package com.movie.manager.repository;

import com.movie.manager.entity.MovieEntity;
import com.movie.manager.entity.ScreenEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScreenRepository extends MongoRepository<ScreenEntity,Integer> {
}
