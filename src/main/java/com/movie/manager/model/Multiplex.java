package com.movie.manager.model;

import java.io.Serializable;
import java.util.Set;

public class Multiplex implements Serializable {

    private static final long serialVersionUID = -4544661768516953834L;


    private Long multiplexId;
    private String multiplexName;
    private String address;
    private Set<Screen> screensList;


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

    public Set<Screen> getScreensList() {
        return screensList;
    }

    public void setScreensList(Set<Screen> screensList) {
        this.screensList = screensList;
    }
}
