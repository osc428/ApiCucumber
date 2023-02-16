package com.devEx.stepDef;

import com.devEx.request.DevExRequest;
import com.devEx.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ProfileStepDefs {

    Response response;

    @Given("User creates a GET request to see all profiles")
    public void user_creates_a_get_request_to_see_all_profiles() {
        response = given().get(ConfigurationReader.get("allProfiles"));
        response.prettyPrint();

    }
    @Then("Verify that status code is {int}")
    public void verify_that_status_code_is(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.statusCode());
    }

    @Given("User creates a GET request to see all profiles with second way")
    public void user_creates_a_get_request_to_see_all_profiles_with_second_way() {
        response = DevExRequest.getAllProfiles();
    }

    @Then("Verify that status code is {int} with second way")
    public void verify_that_status_code_is_with_second_way(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.statusCode());
    }

    @Then("Verify that user info's {string} and {string} and {string} and {string}")
    public void verifyThatUserInfoSAndAndAnd(String name, String email, String company, String location) {
        System.out.println("response.path(\"user.name\") = " + response.path("user.name"));
        System.out.println("response.path(\"user.email\") = " + response.path("user.email"));
        System.out.println("response.path(\"company\") = " + response.path("company"));
        System.out.println("response.path(\"location\") = " + response.path("location"));
    }

    @Given("User creates a GET request with path {string}")
    public void userCreatesAGETRequestWithPath(String id) {
        response = given().pathParam("userID", id).when().get(ConfigurationReader.get("getOneUserWithPathParam"));
    }

}
