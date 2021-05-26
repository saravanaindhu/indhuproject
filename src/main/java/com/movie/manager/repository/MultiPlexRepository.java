package com.movie.manager.repository;

import com.movie.manager.entity.MovieEntity;
import com.movie.manager.entity.MultiplexEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MultiPlexRepository extends MongoRepository<MultiplexEntity,Integer> {

    MultiplexEntity findByMultiplexId(Integer multiPlexId);
}
