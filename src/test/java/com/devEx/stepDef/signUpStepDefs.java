package com.devEx.stepDef;

import com.devEx.common.DataForApi;
import com.devEx.request.DevExRequest;
import com.devEx.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
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

    @And("Compiler gets the token")
    public void comilerGetsTheToken() {
     String token = response.path("token");
        ConfigurationReader.set("newUserToken" , token);
    }

    @Given("User creates a POST request and send the token with {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void userCreatesAPOSTRequestAndSendTheTokenWith(String company, String webSite, String location, String status,
                                                           String skills,String githubusername, String youtube, String twitter,
                                                           String facebook, String linkedin, String instagram) {
            response= DevExRequest.postSaveProfile(company, webSite, location, status, skills, githubusername, youtube, twitter, facebook, linkedin, instagram);

    }

    @Then("Verify that status code should be {int}")
    public void verifyThatStatusCodeShouldBe(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.statusCode());
    }

    @Then("verify that name {string} and email as {string}")
    public void verifyThatNameAndEmailAs(String expectedName, String expectedEmail) {
        Assert.assertEquals(expectedName,response.path("user.name"));
        Assert.assertEquals(expectedEmail,response.path("user.email"));
    }

    @Given("User creates a POST request for add an experience with {string} {string} {string} {string}  {string} {string} {string}")
    public void userCreatesAPOSTRequestForAddAnExperienceWith(String title,String company, String location, String from, String to, String current, String description) {

        response= DevExRequest.postExperience(title, company, location, from, to, current, description);
    }

    int id;
    @And("Compiler gets the experience id")
    public void compilerGetsTheExperienceId() {
        id = response.path("experience.id[0]");
    }


    @And("User creates GET request to get experience with id")
    public void userCreatesGETRequestToGetExperienceWithId() {
    response = DevExRequest.getExperience(id);

    }

    @And("User is on the dashboard page")
    public void userIsOnTheDashboardPage() {
    }

    @Then("Verify that UI experience and API experience must be matched on company as {string}")
    public void verifyThatUIExperienceAndAPIExperienceMustBeMatchedOnCompanyAs(String arg0) {
    }
}
