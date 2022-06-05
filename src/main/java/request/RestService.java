package request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class RestService<T> {

    protected RequestSpecification specReq = new RequestSpecBuilder()
            .setBaseUri("http://test-api.d6.dev.devcaz.com/v2/")
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    protected ResponseSpecification specResp = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();

    protected Response getReq(int id, String pathUrl, String token) {
        return (Response) given()
                .header("Authorization", "Bearer " + token)
                .spec(specReq)
                .basePath(pathUrl + id)
                .get()
                .then().spec(specResp).extract();
    }

    protected Response postReq(T body, String pathUrl, String userName, String password) {
        return (Response) given()
                .auth().preemptive().basic(userName, password)
                .spec(specReq)
                .basePath(pathUrl)
                .body(body)
                .post()
                .then().spec(specResp).extract();
    }

    protected Response postReq(T body, String pathUrl, String token) {
        return (Response) given()
                .header("Authorization", "Bearer " + token)
                .spec(specReq)
                .basePath(pathUrl)
                .body(body)
                .post()
                .then().spec(specResp).extract();
    }

}
