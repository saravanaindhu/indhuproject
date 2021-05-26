package com.movie.manager.service.impl;

import com.movie.manager.entity.MovieEntity;
import com.movie.manager.model.Movies;
import com.movie.manager.repository.MovieRepository;
import com.movie.manager.service.IMovieService;
import com.movie.manager.util.EntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements IMovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private EntityMapper entityMapper;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void addNewMovie(Movies movie) {
        movie.setMovieId(sequenceGeneratorService.generateSequence(MovieEntity.SEQUENCE_NAME));
        this.movieRepository.save(entityMapper.mapMovieModelToEntity(movie));
    }

    @Override
    public void saveMovie(Movies movie){
        this.movieRepository.save(entityMapper.mapMovieModelToEntity(movie));
        log.info("Movie added successfully{}",movie.getName());
    }

    @Override
    public List<Movies> getAllMovies(){
        List<MovieEntity> movieList = this.movieRepository.findAll();
        return entityMapper.mapMovieEntityToModel(movieList);
    }

    @Override
    public void deleteMovie(long movieId) {
        Optional<MovieEntity> movieOptional = movieRepository.findById(movieId);
        if (movieOptional.isPresent()) {
            movieRepository.delete(movieOptional.get());
        }
    }
}
