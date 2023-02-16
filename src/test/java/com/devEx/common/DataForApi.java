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
}
