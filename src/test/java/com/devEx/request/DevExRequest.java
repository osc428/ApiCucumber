package com.devEx.request;

import com.devEx.utilities.ConfigurationReader;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DevExRequest {

    public  static Response getAllProfiles(){
        Response response = given().get(ConfigurationReader.get("allProfiles"));
        response.prettyPrint();
        return response;
    }
}
