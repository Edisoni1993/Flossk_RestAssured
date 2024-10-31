package tests.herokuAppRequests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.HerokuAppTestBase;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetRequestTests extends HerokuAppTestBase {

    @DisplayName("HerokuApp GET request")
    @Test
    public void simpleGetRequest() {

        response = given().accept(ContentType.JSON).log().all()
                .when().get("/booking");

        response.prettyPrint();

        assertEquals(200, response.statusCode(), "Status code is not 200!");
    }
}
