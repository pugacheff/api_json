import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequests extends TestConfig {

    @Test
    public void UserDataPost() {
        try {
            given()
                    .header("Content-Type", "application/json")
                    .body(userDataPost)
                    .when()
                    .log().all()
                    .post(Resources.getUserDataPost())
                    .then()
                    .statusCode(HttpStatus.SC_CREATED)
                    .log().all();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);


        }

    }


    @Test
    public void verifyResponseUserDataSchema() {
        try {
            UserData userData = given()
                    .when()
                    .get(Resources.getUser2EndPointUri())
                    .then()
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/userdataschema")).and()
                    .statusCode(HttpStatus.SC_OK).extract().body().as(UserData.class);
            Assert.assertEquals(userData.getData().getId(), 2);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
        }
    }
}
