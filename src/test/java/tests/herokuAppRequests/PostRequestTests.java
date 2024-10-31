package tests.herokuAppRequests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.HerokuAppTestBase;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostRequestTests extends HerokuAppTestBase {

    @DisplayName("POST Request - Create new booking")
    @Test
    public void addBookingTest(){

        Map<String, Object> newBooking = new LinkedHashMap<>();
        Map<String, Object> bookingDates = new LinkedHashMap<>();

        newBooking.put("firstname", "Edison");
        newBooking.put("lastname", "Bajrami");
        newBooking.put("totalprice", 500);
        newBooking.put("depositpaid", true);
        bookingDates.put("checkin", "2024-10-10");
        bookingDates.put("checkout", "2024-10-12");
        newBooking.put("bookingdates", bookingDates);
        newBooking.put("additionalneeds", "Breakfast included");

        response = given().contentType(ContentType.JSON)
                .and().body(newBooking).log().all()
                .when().post("/booking");

        //response.prettyPrint();

        assertEquals(200, response.statusCode());
    }
}
