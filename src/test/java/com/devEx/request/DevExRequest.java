package com.devEx.request;

import com.devEx.common.DataForApi;
import com.devEx.utilities.ApiUtils;
import com.devEx.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DevExRequest {

    public  static Response getAllProfiles(){
        Response response = given().get(ConfigurationReader.get("allProfiles"));
        response.prettyPrint();
        return response;
    }

    public static Response postSaveProfile(String company, String webSite, String location, String status,
                                           String skills,String githubusername, String youtube, String twitter,
                                           String facebook, String linkedin, String instagram){

        Response response= given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .header("x-auth-token",ConfigurationReader.get("newUserToken"))
                .and()
                .body(DataForApi.saveProfileBody(company, webSite, location, status, skills, githubusername, youtube, twitter, facebook, linkedin, instagram))
                .when()
                .post(ConfigurationReader.get("postSaveProfile"));
        response.prettyPrint();

        return response;
    }

    public static Response postExperience(String title,String company, String location, String from, String to, String current, String description){
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .headers(ApiUtils.getAccessToken(ConfigurationReader.get("email"), ConfigurationReader.get("password")))
                .and()
                .body(DataForApi.experienceBody(title, company, location, from, to, current, description))
                .when()
                .post(ConfigurationReader.get("postExperience"));

        response.prettyPrint();

        return response;

    }

    public static Response getExperience(int id){

        Response response= given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .headers(ApiUtils.getAccessToken(ConfigurationReader.get("email"),ConfigurationReader.get("password")))
                .and()
                .pathParam("id",id)
                .and()
                .get(ConfigurationReader.get("getExperienceWithId"));
        response.prettyPrint();

        return response;
    }


}
