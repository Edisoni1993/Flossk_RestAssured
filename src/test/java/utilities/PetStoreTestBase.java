package utilities;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class PetStoreTestBase {

    protected static Response response;

    @BeforeAll
    public static void init(){
        baseURI = ConfigurationReader.getProperty("petStoreUrl");
    }

    @AfterAll
    public static void destroy(){
        reset();
    }
}
