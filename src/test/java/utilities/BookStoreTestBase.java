package utilities;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class BookStoreTestBase {

    protected static String userId;
    protected static String token;
    protected static String isbn;
    protected static Response response;

    @BeforeAll
    public static void init(){

        baseURI = ConfigurationReader.getProperty("demoQaUrl");
        userId = "de5d75d1-59b4-487e-b632-f18bc0665c0d";
        token  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4";
        isbn = "9781449337711";
    }

    @AfterAll
    public static void destroy(){
        reset();
    }
}
