package tests.petStore;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.ConfigurationReader;
import utilities.PetStoreTestBase;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PostRequestTests extends PetStoreTestBase {

    File addPet = new File(ConfigurationReader.getProperty("addPetFile"));
    File addOrder = new File(ConfigurationReader.getProperty("addOrderFile"));
    File addUser = new File(ConfigurationReader.getProperty("addUserFile"));

    @DisplayName("POST - Add New Pet")
    @Test
    public void addNewPetTest(){

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(addPet).log().all()
                .when().post("/v2/pet")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("POST - Add New Order")
    @Test
    public void addNewOrderTest(){

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON).log().all()
                .and().body(addOrder)
                .when().post("/v2/store/order")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("POST - Add New User")
    @Test
    public void addNewUserTest(){

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(addUser)
                .when().post("/v2/user")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }
}
