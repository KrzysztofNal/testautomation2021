package pl.tmobile.prepaidqa.qaapi.service.singleuser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pl.tmobile.prepaidqa.qaapi.model.deviceuser.DeviceUser;
import pl.tmobile.prepaidqa.qaapi.model.singleuser.SingleUser;
import pl.tmobile.prepaidqa.qaapi.specification.Specification;

import java.util.List;

public class SingleUserService {

    public final static String PATH = "/5a6b69ec3100009d211b8aeb";
    public final static String POST_PATH = "/5a690a1b2e000051007a73cb";

    public static SingleUser getSingleUser() {
        return getSingleUserResponse()
                .then()
                .extract()
                .body()
                .as(SingleUser.class);
    }

    public static Response getSingleUserResponse() {
        return RestAssured
                .given()
                .spec(Specification.reqSpecificationV2())
                .get(PATH)
                .andReturn();
    }

    public static List<SingleUser> postSingleUser(SingleUser singleUser) {
        return postSingleUserResponse(singleUser)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList("", SingleUser.class);

    }

    public static Response postSingleUserResponse(SingleUser singleUser) {
        return RestAssured
                .given()
                .spec(Specification.reqSpecificationV2())
                // dla soap xml w postaci string
//                .body("<tag></tag>")
//                .body(SOAP_STRING)
                .body(singleUser)
                .post(POST_PATH)
                .andReturn();
    }

    static final String SOAP_STRING = "<xmlTag></xmlTag>";


    public static SingleUser getSingleUserQueryParam(String[] name, String surname) {
        return getSingleUserResponse()
                .then()
                .extract()
                .body()
                .as(SingleUser.class);
    }

    public static Response getSingleUserQueryParamResponse(String[] name, String surname) {
        return RestAssured
                .given()
                .queryParam("name", name)
                .queryParam("surname", surname)
                .spec(Specification.reqSpecificationV2())
                .get(PATH)
                .andReturn();
    }

}
