package tests.herokuAppRequests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.HerokuAppTestBase;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatchRequestTests extends HerokuAppTestBase {

    @DisplayName("PATCH Request - Update booking")
    @Test
    public void partialUpdateBookingTest(){

        Map<String, Object> booking = new LinkedHashMap<>();

        booking.put("firstname", "Flamur");
        booking.put("lastname", "Ajvazi");

        response = given().header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .and().contentType(ContentType.JSON)
                .and().body(booking).log().all()
                .when().patch("/booking/1214");

        //response.prettyPrint();

        assertEquals(200, response.statusCode());
    }
}
