package api.requestBuilder;

import api.apiconfigreader.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestBuilder {

    private RequestBuilder() {
    }

    public static RequestSpecification bulidRequestForGetCall() {
        return given()
                .baseUri(ConfigReader.getValue("BASE_URL_API"))
                .log()
                .all();
    }

    public static RequestSpecification bulidRequestForPostCall() {
        return bulidRequestForGetCall()
                .contentType(ContentType.JSON);
    }
}
