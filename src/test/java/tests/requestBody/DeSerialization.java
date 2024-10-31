package tests.requestBody;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Post;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeSerialization{

    Response response;
    String url = ConfigurationReader.getProperty("jsonplaceholderUrl") + "/posts/1";

    @DisplayName("Single Post Pojo method")
    @Test
    public void singlePostPojoMethod(){

        response = given().accept(ContentType.JSON).log().all()
                .when().get( url);

        response.prettyPrint();

        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertTrue(response.contentType().contains("application/json"));

        Post post = response.as(Post.class);

        assertEquals(1, post.getUserId());
        assertEquals(1, post.getId());
        assertTrue(post.getTitle().contains("sunt aut facere repellat"));
        assertTrue(post.getBody().contains("quia et suscipit"));
    }
}
