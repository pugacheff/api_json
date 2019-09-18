
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequests extends TestConfig {

    @Test
    public void verifySuccessResponse() {
        try {
            given()
                    .when()
                    .get(Resources.getUsersPage2EndPointUri())
                    .then()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body("page", equalTo(2), "total", equalTo(12));

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

    @Test
    public void verifyResponseSingleResource() {
        try {
            UserDataSecond userDataSecond = given()
                    .when()
                    .get(Resources.getSingleResources())
                    .then()
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/userdataschemasecond.json")).and()
                    .statusCode(HttpStatus.SC_OK).extract().body().as(UserDataSecond.class);
            Assert.assertEquals(userDataSecond.getData().getId(), 2);
            Assert.assertEquals(userDataSecond.getData().getName(), "fuchsia rose");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);


        }

    }

    @Test
    public void verifyDelayedResponse() {
        try {
            given()
                    .when()
                    .get(Resources.getDelayedResponse())
                    .then()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body("page", equalTo(1), "total", equalTo(12));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
        }
    }
}