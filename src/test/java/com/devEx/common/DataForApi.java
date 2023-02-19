package com.devEx.common;

import java.util.HashMap;
import java.util.Map;

public class DataForApi {
    public static Map<String, Object> registerUserBody(String email, String password, String name, String google, String facebook, String github){
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("email", email);
        userMap.put("password", password);
        userMap.put("name", name);
        userMap.put("google", google);
        userMap.put("facebook", facebook);
        userMap.put("github",github);

        return userMap;
    }

    public static Map<String,Object> saveProfileBody(String company, String webSite, String location, String status,
                                                     String skils,String githubusername, String youtube, String twitter,
                                                     String facebook, String linkedin, String instagram){

        Map<String,Object> profileBody=new HashMap<>();
        profileBody.put("company",company);
        profileBody.put("website",webSite);
        profileBody.put("location",location);
        profileBody.put("status",status);
        profileBody.put("skills",skils);
        profileBody.put("githubusername",githubusername);
        profileBody.put("youtube",youtube);
        profileBody.put("twitter",twitter);
        profileBody.put("facebook",facebook);
        profileBody.put("linkedin",linkedin);
        profileBody.put("instagram",instagram);

        return profileBody;
    }


    /**
     * {
     *   "title": "string",
     *   "company": "string",
     *   "location": "string",
     *   "from": "YYYY-MM-DD",
     *   "to": "YYYY-MM-DD",
     *   "current": false,
     *   "description": "string"
     * }
     */

    public static Map<String,Object> experienceBody(String title,String company, String location, String from, String to, String current, String description){

        Map<String,Object> experienceBody = new HashMap<>();
        experienceBody.put("title", title);
        experienceBody.put("company", company);
        experienceBody.put("location", location);
        experienceBody.put("from", from);
        experienceBody.put("to", to);
        experienceBody.put("current",current);
        experienceBody.put("description", description);

        return experienceBody;

    }
}
