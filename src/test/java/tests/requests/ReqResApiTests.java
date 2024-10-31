package tests.requests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.ReqResTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static io.restassured.RestAssured.given;

public class ReqResApiTests extends ReqResTestBase {

    @DisplayName("Get all users")
    @Test
    public void usersGetTest(){

        response = given().accept("application/json")
                .and().contentType("application/json").log().all()
                .when().get("/api/users");

        response.prettyPrint();

        response.then().statusCode(200);
        assertTrue(response.asString().contains("George"));
        assertTrue(response.contentType().contains("application/json"));
    }

    @DisplayName("GET single user")
    @Test
    public void getSingleUserApiTest(){

        response = given().accept("application/json")
                .and().contentType("application/json").log().all()
                .when().get("/api/users/5");

        assertEquals(200, response.statusCode());
        response.prettyPrint();
        assertTrue(response.asString().contains("Charles"));
    }

    @DisplayName("GET Single User - Negative Test")
    @Test
    public void getSingleUserNegativeTest(){

        response = given().accept("application/json")
                .and().contentType("application/json").log().all()
                .when().get("/api/users/50");

        assertEquals(404, response.statusCode());
        assertEquals("{}", response.asString());
    }
}
