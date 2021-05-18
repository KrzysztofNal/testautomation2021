package pl.tmobile.prepaidqa.qaapi;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.LoggerFactory;
import pl.tmobile.prepaidqa.qaapi.config.ApiConfig;
import pl.tmobile.prepaidqa.qaapi.model.GenericUser;
import pl.tmobile.prepaidqa.qaapi.model.deviceuser.DeviceUser;
import pl.tmobile.prepaidqa.qaapi.model.singleuser.SingleUser;
import pl.tmobile.prepaidqa.qaapi.service.generic.GenericUserService;
import pl.tmobile.prepaidqa.qaapi.service.singleuser.SingleUserService;
import pl.tmobile.prepaidqa.qaapi.specification.RestAssuredRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static pl.tmobile.prepaidqa.qaapi.service.deviceuserservice.DeviceUserService.getDeviceUser;
import static pl.tmobile.prepaidqa.qaapi.service.deviceuserservice.DeviceUserService.getDeviceUserResponse;

@Tag("Api")
@DisplayName("Api Tests")
public class ApiTest {


    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All  ===================================");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before Each  ===================================");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After Each =============================");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All =============================");
    }

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

    @Test
    public void singleUserTest() {
        SingleUser singleUser = SingleUserService.getSingleUser();

        assertThat(singleUser.getName()).isEqualTo("Piotr");
        assertThat(singleUser.getSurname()).isEqualTo("Kowalski");
    }

    @Test
    public void singleGenericTest() throws IOException {
        GenericUser<Integer> user = GenericUserService.getGenericIntUser();

        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getName()).isEqualTo("Piotr");
        assertThat(user.getSurname()).isEqualTo("Kowalski");
    }

    @Test
    public void singleGenericStringTest() throws IOException {
        GenericUser<String> user = GenericUserService.getGenericStringUser();

        assertThat(user.getId()).isEqualTo("1");
        assertThat(user.getName()).isEqualTo("Piotr");
        assertThat(user.getSurname()).isEqualTo("Kowalski");
    }

    @Test
    public void singleUserPostTest(TestInfo info) {
        //given
        SingleUser singleUser = new SingleUser("Paweł", "Kowalski");

        //when
        List<SingleUser> singleUsers = SingleUserService.postSingleUser(singleUser);

        System.out.println(info);
        //then
        assertThat(singleUsers).isEmpty();
    }

    private static final Log log = LogFactory.getLog(ApiTest.class);

    @Test
    public void singleUserWithQueryTest() {

        log.info("================");
        log.info("testowe");
        log.info("================");
        String[] strings = {"pawel", "dawid"};

        SingleUser singleUser = SingleUserService.getSingleUserQueryParam(strings, "Kowalski");

        assertThat(SingleUserService.getSingleUserQueryParamResponse(strings, "Kowalski").statusCode()).isEqualTo(200);
        assertThat(singleUser.getName()).isEqualTo("Piotr");
        assertThat(singleUser.getSurname()).isEqualTo("Kowalski");
    }

    @Test
    public void configTest() {
        System.out.println(ApiConfig.BASE_URL);
    }
}
