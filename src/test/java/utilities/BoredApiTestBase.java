package utilities;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class BoredApiTestBase {

    protected static Response response;

    @BeforeAll
    public static void init(){

        baseURI = ConfigurationReader.getProperty("boredApiUrl");
    }

    @AfterAll
    public static void destroy(){

        reset();
    }
}
