package com.movie.manager.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.Set;
@Document(collection = "multiplex")
public class MultiplexEntity {

    @Transient
    public static final String SEQUENCE_NAME = "multiplex_sequence";

    private Long multiplexId;
    private String multiplexName;
    private String address;
    private Set<ScreenEntity> screenEntityList;

    public Long getMultiplexId() {
        return multiplexId;
    }

    public void setMultiplexId(Long multiplexId) {
        this.multiplexId = multiplexId;
    }

    public String getMultiplexName() {
        return multiplexName;
    }

    public void setMultiplexName(String multiplexName) {
        this.multiplexName = multiplexName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<ScreenEntity> getScreenEntityList() {
        return screenEntityList;
    }

    public void setScreenEntityList(Set<ScreenEntity> screenEntityList) {
        this.screenEntityList = screenEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiplexEntity that = (MultiplexEntity) o;
        return Objects.equals(multiplexId, that.multiplexId) &&
                Objects.equals(multiplexName, that.multiplexName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(multiplexId, multiplexName);
    }
}
