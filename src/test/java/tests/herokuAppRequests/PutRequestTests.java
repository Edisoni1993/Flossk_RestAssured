package tests.herokuAppRequests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.HerokuAppTestBase;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PutRequestTests extends HerokuAppTestBase {

    @DisplayName("PUT Request - Update booking")
    @Test
    public void updateBookingTest(){

        Map<String, Object> booking = new LinkedHashMap<>();
        Map<String, Object> bookingDates = new LinkedHashMap<>();

        booking.put("firstname", "Edison");
        booking.put("lastname", "Bajrami");
        booking.put("totalprice", 1200);
        booking.put("depositpaid", true);
        bookingDates.put("checkin", "2024-10-10");
        bookingDates.put("checkout", "2024-10-14");
        booking.put("bookingdates", bookingDates);
        booking.put("additionalneeds", "Breakfast and dinner included");

        response = given().header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .and().contentType(ContentType.JSON)
                .and().body(booking).log().all()
                .when().put("/booking/1120");

        //response.prettyPrint();

        assertEquals(200, response.statusCode());
    }
}
