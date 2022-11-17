package dev.danvega.controller;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping
    public String home(Principal principal) {
        return "Hello, JWT  " + principal.getName();
    }

    @GetMapping("/test")
    public String test() throws JSONException {
        String json = "[{\"title\":\"test\",\"date\":\"2022-05-23\"}]";
        JSONArray jsonArray = new JSONArray(json);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        return jsonObject.toString();
    }

}
