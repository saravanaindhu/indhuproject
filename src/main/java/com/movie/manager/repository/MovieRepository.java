package com.movie.manager.repository;

import com.movie.manager.entity.MovieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface MovieRepository extends MongoRepository<MovieEntity,Long> {
}
