package pl.tmobile.prepaidqa.qaapi.specification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.params.CoreConnectionPNames;
import pl.tmobile.prepaidqa.qaapi.config.ApiConfig;

import static io.restassured.filter.log.LogDetail.ALL;

public class Specification {

    public static RequestSpecification reqSpecificationV2() {
        return  new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(ApiConfig.BASE_MOCK_URL)
                .setBasePath(ApiConfig.BASE_MOCK_PATH)
//                .addFilter(new RestAssuredRequestFilter())
                .log(ALL)
                .setConfig(config)
                .build();
    }

//    private static AUTH_KEY = methodaDoAuthorzycaji()
    public static RequestSpecification reqSpecificationAzureV1() {
        return  new RequestSpecBuilder()
//                .addHeader("Authorization", "Bearer " + "authKey")
                .setContentType(ContentType.JSON)
                .setBaseUri(ApiConfig.BASE_AZURE_URL)
                .setBasePath(ApiConfig.BASE_AZURE_PATH)
//                .addFilter(new RestAssuredRequestFilter())
                .log(ALL)
                .setConfig(config)
                .build();
    }

    private final static RestAssuredConfig config = RestAssured.config()
            .httpClient(HttpClientConfig.httpClientConfig()
                    .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000)
                    .setParam(CoreConnectionPNames.SO_TIMEOUT, 1000));
}
