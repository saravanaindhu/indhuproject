package com.movie.manager.model;

import java.io.Serializable;

public class Screen implements Serializable {

    private static final long serialVersionUID = 1812004039544251286L;

    private Long screenId;
    private Integer movieId;
    private Integer multiplexId;
    private Integer screenNumber;

    public Long getScreenId() {
        return screenId;
    }

    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getMultiplexId() {
        return multiplexId;
    }

    public void setMultiplexId(Integer multiplexId) {
        this.multiplexId = multiplexId;
    }

    public Integer getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(Integer screenNumber) {
        this.screenNumber = screenNumber;
    }
}
