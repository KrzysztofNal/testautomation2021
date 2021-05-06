package pl.tmobile.prepaidqa.qaapi.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {

    public final static String PATH = "/v2";
    public final static String BASE_URI = "http://www.mocky.io";

    public static RequestSpecification reqSpecificationV2() {
        return  new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URI)
                .setBasePath(PATH)
                .build();
    }
}
