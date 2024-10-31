package tests.petStore;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.PetStoreTestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetRequestTests extends PetStoreTestBase {

    @DisplayName("GET - Pet by status")
    @Test
    public void getPetByStatusTest(){

        given().accept(ContentType.JSON)
                .and().queryParam("status", "available")
                .when().get("/v2/pet/findByStatus")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("GET - Pet by ID")
    @Test
    public void getPetByIdTest(){

        given().accept(ContentType.JSON)
                .when().get("/v2/pet/9223372036854775257")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .and().body("name", is("doggie"),
                        "status", is("available"));
    }

    @DisplayName("GET - ORDER")
    @Test
    public void getOrderTest(){

        given().accept(ContentType.JSON)
                .when().get("/v2/store/order/58570377")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .and().body("id", is(58570377),
                        "petId", is(4),
                        "status", is("placed"));
    }

    @DisplayName("GET - USER")
    @Test
    public void getUserTest(){

        given().accept(ContentType.JSON)
                .when().get("/v2/user/Edison_Bajrami")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .and().body("id", is(123),
                        "username", is("Edison_Bajrami"),
                        "firstName", is("Edison"),
                        "lastName", is("Bajrami"),
                        "email", is("edison.bajrami@example.com"));
    }
}
