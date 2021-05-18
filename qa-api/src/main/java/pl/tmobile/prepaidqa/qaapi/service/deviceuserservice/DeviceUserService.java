package pl.tmobile.prepaidqa.qaapi.service.deviceuserservice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pl.tmobile.prepaidqa.qaapi.model.deviceuser.DeviceUser;
import pl.tmobile.prepaidqa.qaapi.specification.Specification;

import java.util.List;

public class DeviceUserService {

    public final static String PATH = "/5a6a58222e0000d0377a7789";

    public static List<DeviceUser> getDeviceUser() {
        return getDeviceUserResponse()
                .then()
                .log().all()
                .extract()
                .body()
                .jsonPath()
                .getList("", DeviceUser.class);
    }

    public static Response getDeviceUserResponse() {
        return RestAssured
                .given()
                .spec(Specification.reqSpecificationV2())
                .get(PATH)
                .andReturn();
    }


}
