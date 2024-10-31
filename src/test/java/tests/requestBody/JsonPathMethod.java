package tests.requestBody;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.ZippopotamTestBase;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonPathMethod extends ZippopotamTestBase {


    @DisplayName("GET us/zipcode - jsonPath")
    @Test
    public void zipCodeJsonPathTest(){

        response = given().accept(ContentType.JSON)
                .and().pathParam("country", "us")
                .and().pathParam("postal-code", 22102).log().all()
                .when().get("/{country}/{postal-code}");

        response.prettyPrint();

        assertEquals(HttpStatus.SC_OK, response.statusCode());

        JsonPath jsonPath = response.jsonPath();

        assertEquals("United States", jsonPath.getString("country"));
        verifyZipCode(jsonPath, "22102");
        assertEquals("Mc Lean", jsonPath.getString("places[0].'place name'"));
        assertEquals("Virginia", jsonPath.getString("places[0].state"));
    }
}
