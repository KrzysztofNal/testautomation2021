package pl.tmobile.prepaidqa.qaapi.azure.service.activities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pl.tmobile.prepaidqa.qaapi.azure.model.activities.Activities;
import pl.tmobile.prepaidqa.qaapi.specification.Specification;

import java.util.HashMap;
import java.util.Map;

public class ActivitiesService {

    public final static String ACTIVITIES_URL = "/Activities/{id}";

    public static Activities getActivitiesById(long id) {
        return getResponseActivitiesById(id)
                .then()
                .log().all()
                .extract()
                .body()
                .as(Activities.class);
    }

    public static Response getResponseActivitiesById(long id) {
        return RestAssured
                .given()
                .spec(Specification.reqSpecificationAzureV1())
                .get(ACTIVITIES_URL, id)
                .andReturn();
    }



    public final static String ACTIVITIES_URL_MULTI_PARAM = "/Activities/{id}/someUrl/{name}"; //dla przypadku kilku parametrów

    // przykłąd dla przykładu kilku path parametrów
        public static Activities getActivitiesById(long id, String name) {//dla przypadku kilku parametrów
        return getResponseActivitiesById(id, name)//dla przypadku kilku parametró
                .then()
                .extract()
                .body()
                .as(Activities.class);
    }

        public static Response getResponseActivitiesById(long id, String name) {  //dla przypadku kilku parametrów
            Map<String, String>  pathParams = new HashMap<>();
            pathParams.put("id", "1");
            pathParams.put("name", "pawel");

        return RestAssured
                .given()
                .spec(Specification.reqSpecificationAzureV1())
//                .get(ACTIVITIES_URL_MULTI_PARAM, pathParams)  //dla przypadku kilku parametrów
                .get(ACTIVITIES_URL_MULTI_PARAM, id, name)  //dla przypadku kilku parametrów
                .andReturn();
    }


}
