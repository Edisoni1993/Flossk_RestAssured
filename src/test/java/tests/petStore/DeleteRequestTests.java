package tests.petStore;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utilities.ConfigurationReader;
import utilities.PetStoreTestBase;

import java.io.File;

import static io.restassured.RestAssured.given;

public class DeleteRequestTests extends PetStoreTestBase {

    File addOrder = new File(ConfigurationReader.getProperty("addOrderFile"));
    File addUser = new File(ConfigurationReader.getProperty("addUserFile"));

    @DisplayName("DELETE - Delete Order")
    @Test
    public void deleteOrderTest(){

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .when().delete("/v2/store/order/58570377")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("POST - Add New Order")
    @Test
    public void addNewOrderTest(){

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(addOrder)
                .when().post("/v2/store/order")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("DELETE - Delete User")
    @Test
    public void deleteUserTest(){

        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .when().delete("/v2/user/Edison_Bajrami")
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
