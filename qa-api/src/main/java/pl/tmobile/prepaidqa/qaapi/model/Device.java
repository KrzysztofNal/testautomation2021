package pl.tmobile.prepaidqa.qaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Device {
    public String type;

    @JsonProperty("device.model")
    public List<DeviceModel> deviceModel;
}
