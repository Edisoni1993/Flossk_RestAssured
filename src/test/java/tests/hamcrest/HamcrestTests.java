package tests.hamcrest;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class HamcrestTests {

    @DisplayName("GET us/zipcode - Hamcrest")
    @Test
    public void zipCodeHamcrestTest() {

        baseURI = ConfigurationReader.getProperty("zippopotamUrl");

        given().accept(ContentType.JSON)
                .and().pathParam("country", "us")
                .and().pathParam("postal-code", 22102).log().all()
                .when().get("/{country}/{postal-code}")
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .assertThat().contentType(ContentType.JSON.toString())
                .body("country", is("United States"),
                        "'post code'", is("22102"),
                        "places[0].'place name'", is("Mc Lean"),
                        "places[0].state", is("Virginia")).and().log().all();
    }
}
