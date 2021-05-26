package com.movie.manager.controller;

import com.movie.manager.model.Movies;
import com.movie.manager.model.RestResponse;
import com.movie.manager.service.impl.MovieServiceImpl;
import com.movie.manager.util.ResponseBuilder;
import io.swagger.annotations.ApiOperation;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MovieController {

    @Autowired
    ResponseBuilder responseBuilder;

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    MovieServiceImpl movieService;


    @PutMapping(path = "/movie/")
    @ApiOperation(value = "This operation perform to SAVE a movie")
    @PreAuthorize("permitAll()")
    public ResponseEntity<RestResponse<RestResponse>> createMovie(@RequestBody final Movies movieRequest){
        ResponseEntity<RestResponse<RestResponse>> response;
        RestResponse restResponse = new RestResponse();
        movieService.addNewMovie(movieRequest);
        restResponse.setSuccess(true);
        restResponse.setMessage("Movie added successfully");
        response = responseBuilder.buildResponse(restResponse,HttpStatus.OK,"OK");
        return response;
    }

    @GetMapping(path = "/movie/")
    @ApiOperation(value = "This operation perform to get all movies")
    @PreAuthorize("permitAll()")
    public ResponseEntity<RestResponse<List<Movies>>> getAllMovies(){
        ResponseEntity<RestResponse<List<Movies>>> response;
        response = responseBuilder.buildResponse(movieService.getAllMovies(), HttpStatus.OK, "OK");
        return response;
    }

    @DeleteMapping(path = "/movie/{movieId}")
    public ResponseEntity<RestResponse<RestResponse>> deleteMovie(@PathVariable long movieId){
        ResponseEntity<RestResponse<RestResponse>> response;
        RestResponse restResponse = new RestResponse();
        movieService.deleteMovie(movieId);
        restResponse.setSuccess(true);
        restResponse.setMessage("Movie added successfully");
        response = responseBuilder.buildResponse(restResponse,HttpStatus.OK,"OK");
        return response;
    }

}
