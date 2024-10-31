package tests.parameters;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.BoredApiTestBase;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueryParamsTests extends BoredApiTestBase {

    @DisplayName("GET - Query params")
    @Test
    public void getRecreationalActivityTest(){

        response = given().accept(ContentType.JSON)
                .and().queryParam("type", "education").log().all()
                .when().get("filter");

        response.prettyPrint();

        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertTrue(response.contentType().contains("application/json"));
        assertTrue(response.asString().contains("education"));
    }

    @DisplayName("GET - multiple query params")
    @Test
    public void getActivityTest(){

        response = given().accept(ContentType.JSON)
                .and().queryParam("minprice", "0")
                .and().queryParam("maxprice", "0.1")
                .when().get("filter");

        response.prettyPrint();

        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertTrue(response.contentType().contains("application/json"));
    }
}
