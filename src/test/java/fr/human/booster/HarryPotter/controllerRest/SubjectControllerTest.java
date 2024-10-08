package fr.human.booster.HarryPotter.controllerRest;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class SubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "toto@gmail.com")
    public void testFindBySearchStringSuccess() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                get("/api/subject/Astronomie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJsonByData("Astronomie")
                        )
        );
        resultActions.andExpect(status().is2xxSuccessful())
                .andExpect(authenticated());
    }

    @Test
    @WithMockUser(username = "toto@gmail.com")
    public void testFindBySearchIntSuccess() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                get("/api/subject/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJsonByData(1)
                        )
        );
        resultActions.andExpect(status().is2xxSuccessful())
                .andExpect(authenticated());
    }

    @Test
    @WithMockUser(username = "toto@gmail.com")
    public void testFindBySearchFail() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                get("/api/subject/bla")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJsonByData("bla")
                        )
        );
        resultActions.andExpect(status().is4xxClientError());
    }

    private String getJsonByData(String search) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("search", search);
        return json.toString();
    }

    private String getJsonByData(Integer search) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("search", search);
        return json.toString();
    }
}
