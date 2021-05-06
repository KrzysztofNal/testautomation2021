package pl.tmobile.prepaidqa.qaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DeviceUser {
    @JsonProperty("imie")
    public String name;
    @JsonProperty("nazwisko")
    public String surname;
    public List<Device> device;
}
