package tests.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.ConfigurationReader;

public class HelloWorldGetRequest {

    String url = ConfigurationReader.getProperty("sandboxApiUrl") + "/hello-world/hello/world";

    @DisplayName(("Hello World GET request"))
    @Test
    public void helloWorldGetRequestTest(){

        Response response = RestAssured.get(url);

        response.prettyPrint();

        assertEquals(200, response.statusCode(), "Status code is not 200!");
        assertTrue(response.asString().contains("Hello World!"), "Status body doesn't contain the string");
    }
}
