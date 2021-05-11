package pl.tmobile.prepaidqa.qaapi.model.deviceuser;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Device {
    public String type;

    @JsonProperty("device.model")
    public List<DeviceModel> deviceModel;
}
