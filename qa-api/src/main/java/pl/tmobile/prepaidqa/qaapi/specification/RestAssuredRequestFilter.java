package pl.tmobile.prepaidqa.qaapi.specification;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RestAssuredRequestFilter implements Filter {
    private static final Log log = LogFactory.getLog(RestAssuredRequestFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);

        log.info("===========================================");
        log.info("testowe");
        log.info("\n" +
                "Request method: " + requestSpec.getMethod() + "\n" +
                "Request URI: " + requestSpec.getURI() + "\n" +
                "Request path params: " + requestSpec.getPathParams() + "\n" +
                "Request params: " + requestSpec.getRequestParams() + "\n" +
                "Request query params: " + requestSpec.getQueryParams() + "\n" +
                "Request headers: " + requestSpec.getHeaders() + "\n" +
                "Request content type: " + requestSpec.getContentType() + "\n" +
                "Request cookies: " + requestSpec.getCookies() + "\n" +
                "Request multiparts: " + requestSpec.getMultiPartParams() + "\n" +
                "Request Body: " + requestSpec.getBody()
        );
        log.info("===========================================");

        log.info("\n" +
                "Response status: " + response.getStatusCode() + "\n" +
                 "Response status line: " + response.getStatusLine() + "\n" +
                 "Response content type: " + response.getContentType() + "\n" +
                 "Response headers: " + response.getHeaders() + "\n" +
                 "Response body: " + response.getBody().prettyPrint()
                );
        log.info("===========================================");
        return response;
    }
}
