package Business.Tour.controllers;

import Business.Tour.entities.GameScore;
import Business.Tour.repositories.GameScoreRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(GameScoreController.class)
public class GameScoreControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @InjectMocks
    GameScoreController gameScoreController;

    @MockBean
    GameScoreRepository gameScoreRepository;

    private JacksonTester<GameScore> jsonGameScore;

    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void get_all_game_scores() throws Exception {
        GameScore gameScore = new GameScore(1L,
                1000000L,
                10L,
                15L,
                15,
                true,
                1L);

        List<GameScore> listGameScore = new ArrayList<>();
        listGameScore.add(gameScore);
        when(gameScoreRepository.findAll()).thenReturn(listGameScore);

       mockMvc.perform(get("/gamescores/")
               .contentType(MediaType.APPLICATION_JSON)
               .characterEncoding("UTF-8"))
               .andDo(print())
               .andExpect(content().json("[{\"id\":1,\"moneyEarned\":1000000,\"nbOfPropertiesBought\":10,\"totalDuration\":15,\"nbTurns\":15,\"isWin\":true,\"idUser\":1}]"))
               .andExpect(status().isOk());
    }

    @Test
    public void add_a_game_score() throws Exception{
        GameScore gameScore = new GameScore(1L,1000000L, 10L, 15L, 15, true, 1L);

        MockHttpServletResponse response = mockMvc.perform(
                post("/gamescores/").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(
                        jsonGameScore.write(gameScore).getJson()
                ))

                .andDo(print())
                .andReturn()
                .getResponse();

       assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

    @Test
    public void get_one_game_score() throws Exception {

        GameScore gameScore = new GameScore(1L,1000000L, 10L, 15L, 15, true, 1L);
        when(gameScoreRepository.findById(1L)).thenReturn(Optional.of(gameScore));


        mockMvc.perform(get("/gamescores/1")

                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"moneyEarned\":1000000,\"nbOfPropertiesBought\":10,\"totalDuration\":15,\"nbTurns\":15,\"isWin\":true,\"idUser\":1}"))
                .andReturn();


    }

    @Test
    public void replace_game_score() {
    }

    @Test
    public void deleteGameScore() throws Exception {
        GameScore gameScore = new GameScore(1L,1000000L, 10L, 15L, 15, true, 1L);

        when(gameScoreRepository.findById(1L)).thenReturn(Optional.of(gameScore));

        mockMvc.perform(MockMvcRequestBuilders.delete("/gamescores/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}