package pl.tmobile.prepaidqa.qaapi.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {

    public final static String PATH = "/v2";
    public final static String BASE_URI = "http://www.mocky.io";
    public final static String BASE_AZURE_URI = "https://fakerestapi.azurewebsites.net";
    public final static String BASE_PATH_AZURE = "/api/v1";

    public static RequestSpecification reqSpecificationV2() {
        return  new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URI)
                .setBasePath(PATH)
                .build();
    }

//    private static AUTH_KEY = methodaDoAuthorzycaji()
    public static RequestSpecification reqSpecificationAzureV1() {
        return  new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + "authKey")
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_AZURE_URI)
                .setBasePath(BASE_PATH_AZURE)
                .build();
    }
}
