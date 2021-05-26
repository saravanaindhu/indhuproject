package com.movie.manager.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "screen")
public class ScreenEntity {

    @Transient
    public static final String SEQUENCE_NAME = "screen_sequence";

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreenEntity that = (ScreenEntity) o;
        return Objects.equals(screenId, that.screenId) &&
                Objects.equals(multiplexId, that.multiplexId) &&
                Objects.equals(screenNumber, that.screenNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screenId, multiplexId, screenNumber);
    }
}
