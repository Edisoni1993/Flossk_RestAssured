package tests.herokuAppRequests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.HerokuAppTestBase;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteRequestTests extends HerokuAppTestBase {

    @DisplayName("DELETE Request - Delete a booking")
    @Test
    public void deleteBooking() {

        response = given().header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .and().contentType(ContentType.JSON).log().all()
                .when().delete("/booking/1400");

        //response.prettyPrint();
        assertEquals(201, response.statusCode());
    }
}
