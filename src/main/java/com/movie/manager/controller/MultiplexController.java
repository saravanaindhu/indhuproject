package com.movie.manager.controller;

import com.movie.manager.model.Multiplex;
import com.movie.manager.model.RestResponse;
import com.movie.manager.model.Screen;
import com.movie.manager.service.impl.MultiplexServiceImpl;
import com.movie.manager.util.ResponseBuilder;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MultiplexController {

    @Autowired
    ResponseBuilder responseBuilder;

    @Autowired
    MultiplexServiceImpl multiplexService;


    @GetMapping(path = "/screen/")
    @ApiOperation(value = "This operation perform to get all screens")
    public ResponseEntity<RestResponse<List<Screen>>> getAllScreens(){
        ResponseEntity<RestResponse<List<Screen>>> response;
        response = responseBuilder.buildResponse(multiplexService.getAllScreens(), HttpStatus.OK, "OK");
        return  response;
    }

    @GetMapping(path = "/multiplex/")
    @ApiOperation(value = "This operation perform to get all multiplex")
    public ResponseEntity<RestResponse<Multiplex>> getMuliplexById(@RequestParam Integer multiplexId){
        ResponseEntity<RestResponse<Multiplex>> response;
        response = responseBuilder.buildResponse(multiplexService.getMultiplexById(multiplexId), HttpStatus.OK, "OK");
        return  response;
    }

    @PostMapping(path = "/screen/")
    @ApiOperation(value = "This operation perform to SAVE a screen")
    public ResponseEntity<RestResponse<RestResponse>> saveMovie(@RequestBody final Screen screenRequest){
        ResponseEntity<RestResponse<RestResponse>> response;
        RestResponse respons = new RestResponse();
        System.out.println(screenRequest);
        multiplexService.saveScreen(screenRequest);
        respons.setSuccess(true);
        respons.setMessage("Screen added successfully");
        response = responseBuilder.buildResponse(respons,HttpStatus.OK,"OK");

        return response;

    }

    @PostMapping(path = "/multiplex/")
    @ApiOperation(value = "This operation perform to SAVE a Multiplex")
    public ResponseEntity<RestResponse<RestResponse>> saveMultiplex(@RequestBody final Multiplex multiplexRequest){
        ResponseEntity<RestResponse<RestResponse>> response;
        RestResponse respons = new RestResponse();
        System.out.println(multiplexRequest);
        multiplexService.saveMutliplex(multiplexRequest);
        respons.setSuccess(true);
        respons.setMessage("Multiplex added successfully");
        response = responseBuilder.buildResponse(respons,HttpStatus.OK,"OK");

        return response;

    }
}
