package com.movie.manager.service;

import com.movie.manager.model.Movies;

import java.util.List;

public interface IMovieService {

    void addNewMovie(Movies movie);
    void saveMovie(Movies movie);
    List<Movies> getAllMovies();
    void deleteMovie(long MovieId);
}
