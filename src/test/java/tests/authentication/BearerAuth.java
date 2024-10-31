package tests.authentication;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.BookStoreTestBase;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BearerAuth extends BookStoreTestBase {

    @DisplayName("Update book with Bearer auth")
    @Test
    public void updateBook() {

        Map<String, Object> books = new HashMap<>();
        books.put("isbn", isbn);
        books.put("userId", userId);

        response = given().header("Authorization", "Bearer " + token)
                .and().header("Content-Type", "application/json").log().all()
                .and().body(books).put("/swagger/BookStore/v1/Book/9781449325862");

        assertEquals(200, response.statusCode());
        assertEquals("text/html; charset=utf-8", response.contentType());
    }
}
