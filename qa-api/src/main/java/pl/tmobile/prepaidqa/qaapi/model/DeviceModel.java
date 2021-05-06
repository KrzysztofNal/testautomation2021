package pl.tmobile.prepaidqa.qaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceModel {

    public String produce;

    @JsonProperty("screen.size")
    public double screenSize;
}
