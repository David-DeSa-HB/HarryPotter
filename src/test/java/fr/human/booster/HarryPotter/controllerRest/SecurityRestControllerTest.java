package fr.human.booster.HarryPotter.controllerRest;


import fr.human.booster.HarryPotter.dto.UserCreateDTO;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
public class SecurityRestControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testLoginSuccess() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getLoginJsonFromData("FrancoisMélissa@toto.toto", "12345*")));
        resultActions.andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.token").exists()
                );
    }

    @Test
    public void testLoginFailed() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getLoginJsonFromData("FrancoisMélissa@toto.toto", "12365*")));
        resultActions.andExpect(status().is4xxClientError());
    }

    @Test
    public void testLoginNoEmailFailed() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getLoginJsonFromData("", "12345*")));
        resultActions.andExpect(status().is4xxClientError());
    }

    @Test
    public void testLoginEmailNoAtFailed() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getLoginJsonFromData("FrancoisMélissatoto.toto", "12345*")));
        resultActions.andExpect(status().is4xxClientError());
    }

    @Test
    public void testLoginEmailNoDotFailed() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getLoginJsonFromData("FrancoisMélissa@totototo", "12345*")));
        resultActions.andExpect(status().is4xxClientError());
    }

    @Test
    public void testLoginNoPWDFailed() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getLoginJsonFromData("FrancoisMélissa@toto.toto", "")));
        resultActions.andExpect(status().is4xxClientError());
    }


    private String getLoginJsonFromData(String email, String pwd) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("email", email);
        json.put("password", pwd);
        return json.toString();
    }

    @Test
    public void testRegisterFailed() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                post("/api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getRegisterJsonFromDTO(new UserCreateDTO("FrancoisMélissa@toto.toto",
                                "padoum",
                                "12345*",
                                "12345*")
                        )));
        resultActions.andExpect(status().is4xxClientError());
    }

    private String getRegisterJsonFromDTO(UserCreateDTO dto) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("email", dto.getEmail());
        json.put("nickname", dto.getNickname());
        json.put("password", dto.getPassword());
        json.put("confirmedPassword", dto.getConfirmedPassword());
        return json.toString();
    }
}
