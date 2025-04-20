package com.erick.company.controller;

import com.erick.company.config.SecurityConfig;
import com.erick.company.service.TokenService;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({HomeController.class, AuthController.class})
@Import({SecurityConfig.class, TokenService.class})
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private HomeController homeController;
    /*
     @SpringBootTest is the general test annotation. If you're looking for something that does the same thing prior to 1.4, that's the one you should use. It does not use slicing at all which means it'll start your full application context and not customize component scanning at all.

    @WebMvcTest is only going to scan the controller you've defined and the MVC infrastructure. That's it. So if your controller has some dependency to other beans from your service layer, the test won't start until you either load that config yourself or provide a mock for it. This is much faster as we only load a tiny portion of your app. This annotation uses slicing.
    @SpringBootTest annotation tells Spring Boot to go and look for a main configuration class (one with @SpringBootApplication for instance), and use that to start a Spring application context. SpringBootTest loads complete application and injects all the beans which can be slow.

    @WebMvcTest - for testing the controller layer and you need to provide remaining dependencies required using Mock Objects.
     */

    @Test
    @DisplayName("Return 401 Status When User Is not Authenticated")
    void rootWhenUnauthenticatedThen401() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isUnauthorized());

    }

    @Test
    void rootWhenAuthenticatedThanSayHelloUser() throws Exception {
       MvcResult result = mockMvc.perform(post("/token")
                        .with(httpBasic("dvega", "password")))
                .andExpect(status().isOk())
                .andReturn();

        String token = result.getResponse().getContentAsString();

        mockMvc.perform(get("/")
                        .header("Authorization", "Bearer " + token))
                .andExpect(content().string("Hello, JWT  dvega"));
    }

    @Test
    public void tesGetUsers() throws Exception {
        mockMvc.perform(get("/test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("test"));
    }

    @Test
    public void tesGetUsersWithoutMvcTest() throws Exception {
        JSONObject expectedJsonObject = new JSONObject();
        expectedJsonObject.put("title", "test");
        expectedJsonObject.put("date","2022-05-23");

        mockMvc.perform(get("/test"))
                .andExpect(content()
                        .string(expectedJsonObject.toString()))
                .andExpect(status().isOk());
        /*
        String result = homeController.test();
        JSONObject jsonObjectResponse = new JSONObject(result);
        */

        //assertEquals(expectedJsonObject.toString(), jsonObjectResponse.toString());
    }


    @Test
    @WithMockUser
    void rootWithMockUserStatusIsOk() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }
}