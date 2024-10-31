package tests.authentication;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class BasicAuth {

    String url = ConfigurationReader.getProperty("postmanEchoUrl") + "/basic-auth";

    @DisplayName("GET request with Basic Auth")
    @Test
    public void getRequestWithAuthTest(){

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().auth().basic("postman", "password").log().all()
                .when().get(url)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .and().contentType(ContentType.JSON)
                .and().assertThat().body("authenticated", is(true))
                .and().log().all();
    }

    @DisplayName("Negative GET request with Basic Auth")
    @Test
    public void negativeGetRequestWithAuthTest(){

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().auth().basic("postman", "passwordaa")
                .when().get(url)
                .then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED)
                .and().log().all();
    }
}
