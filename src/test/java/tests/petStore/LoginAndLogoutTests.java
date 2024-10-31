package tests.petStore;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.PetStoreTestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;

public class LoginAndLogoutTests extends PetStoreTestBase {

    String username = "user1";
    String password = "password$1";

    @DisplayName("LOGIN - USER")
    @Test
    public void loginUserTest(){

        given().accept(ContentType.JSON)
                .and().auth().basic(username, password)
                .when().get("/v2/user/login")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("LOGOUT - USER")
    @Test
    public void logoutUserTest(){

        given().accept(ContentType.JSON)
                .and().auth().basic(username, password)
                .when().get("/v2/user/logout")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }
}
