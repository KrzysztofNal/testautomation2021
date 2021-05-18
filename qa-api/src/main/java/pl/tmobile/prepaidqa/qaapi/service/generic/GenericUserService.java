package pl.tmobile.prepaidqa.qaapi.service.generic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pl.tmobile.prepaidqa.qaapi.model.GenericUser;
import pl.tmobile.prepaidqa.qaapi.specification.Specification;

import java.io.IOException;

public class GenericUserService {

    public final static String PATH = "/5b05bf3f3200007100ebfa04";

    public static GenericUser<Integer> getGenericIntUser() throws IOException {
        return new ObjectMapper().readValue(
                getGenericUserResponse()
                        .then()
                        .log().all()
                        .extract()
                        .body()
                        .asInputStream(), new TypeReference<>() {}
        );
    }

    public static GenericUser<String> getGenericStringUser() throws IOException {
        return new ObjectMapper().readValue(
                getGenericUserResponse()
                        .then()
                        .log().all()
                        .extract()
                        .body()
                        .asInputStream(), new TypeReference<>() {}
        );
    }

    public static Response getGenericUserResponse() {
        return RestAssured
                .given()
                .spec(Specification.reqSpecificationV2())
                .get(PATH)
                .andReturn();
    }
}
