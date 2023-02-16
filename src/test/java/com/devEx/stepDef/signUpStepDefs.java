package com.devEx.stepDef;

import com.devEx.common.DataForApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class signUpStepDefs {

    Response response;
    @Given("User creates a POST request with {string} and {string} and {string} and {string} and {string} and {string}")
    public void user_creates_a_post_request_with_and_and_and_and_and(String email, String password, String name, String google, String facebook, String github) {
            response = given().contentType(ContentType.JSON).body(DataForApi.registerUserBody(email,password,name,google,facebook,github))
                    .when().post("/api/users");
            response.prettyPrint();
    }

    @Then("Verify that body contains \"token")
    public void verify_that_body_contains_token() {
        Assert.assertTrue(response.body().asString().contains("token"));
    }

    @Then("Verify that status code for register request is {int}")
    public void verifyThatStatusCodeForRegisterRequestIs(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.statusCode());
    }
}
