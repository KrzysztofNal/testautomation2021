package pl.tmobile.prepaidqa.qaapi;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.tmobile.prepaidqa.qaapi.model.DeviceUser;
import pl.tmobile.prepaidqa.qaapi.service.DeviceUserService;
import pl.tmobile.prepaidqa.qaapi.specification.Specification;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static pl.tmobile.prepaidqa.qaapi.service.DeviceUserService.getDeviceUser;
import static pl.tmobile.prepaidqa.qaapi.service.DeviceUserService.getDeviceUserResponse;

@Tag("Api")
@DisplayName("Api Tests")
public class ApiTest {


    @Test
    public void firstApiTest() {
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));
    }

    @Test
    public void deviceTest() {
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie", equalTo("Piotr"))
                .body("[0].nazwisko", equalTo("Kowalski"))
                .body("[0].device[0].type", equalTo("computer"));
//                .body("[0].device[0].device.model", equalTo("computer"));
    }

    @Test
    public void deviceMultiTest() {
        Response response = RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .andReturn();

        assertThat(response.statusCode()).isEqualTo(200);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(200),
//                () -> assertThat(response.statusCode()).isEqualTo(202),
                () -> assertThat(response.statusCode()).isEqualTo(200)
//                () -> assertThat(response.statusCode()).isEqualTo(203)
        );
    }

    @Test
    public void nextDeviceMultiTest() {

        RequestSpecification spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://www.mocky.io")
                .setBasePath("/v2")
                .build();

        Response response = RestAssured
                .given()
                .spec(spec)
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .andReturn();

        List<DeviceUser> deviceUser = response.then().extract().body().jsonPath().getList("", DeviceUser.class);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(200),
                () -> assertThat(deviceUser.get(0).name).isEqualTo("Piotr"),
                () -> assertThat(deviceUser.get(0).surname).isEqualTo("Kowalski"),
                () -> assertThat(deviceUser.get(0).device.get(0).type).isEqualTo("computer"),
                () -> assertThat(deviceUser.get(0).device.get(0).deviceModel.get(0).produce).isEqualTo("dell"),
                () -> assertThat(deviceUser.get(0).device.get(0).deviceModel.get(0).screenSize).isEqualTo(17),
                () -> assertThat(deviceUser.get(1).device.get(1).deviceModel.get(0).screenSize).isEqualTo(5.5)

        );

    }

    @Test
    public void nextServiceDeviceMultiTest() {

        List<DeviceUser> deviceUser = getDeviceUser();

        assertAll(
                () -> assertThat(getDeviceUserResponse().statusCode()).isEqualTo(200),
                () -> assertThat(deviceUser.get(0).name).isEqualTo("Piotr"),
                () -> assertThat(deviceUser.get(0).surname).isEqualTo("Kowalski"),
                () -> assertThat(deviceUser.get(0).device.get(0).type).isEqualTo("computer"),
                () -> assertThat(deviceUser.get(0).device.get(0).deviceModel.get(0).produce).isEqualTo("dell"),
                () -> assertThat(deviceUser.get(0).device.get(0).deviceModel.get(0).screenSize).isEqualTo(17),
                () -> assertThat(deviceUser.get(1).device.get(1).deviceModel.get(0).screenSize).isEqualTo(5.5)

        );

    }
}
