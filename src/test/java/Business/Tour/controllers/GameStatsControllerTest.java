package Business.Tour.controllers;

import Business.Tour.entities.GameStat;
import Business.Tour.repositories.GameStatRepository;
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
@WebMvcTest(GameStatController.class)
public class GameStatsControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @InjectMocks
    GameStatController gameScoreController;

    @MockBean
    GameStatRepository gameStatRepository;

    private JacksonTester<GameStat> jsonGameScore;

    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAll() throws Exception {
        GameStat gameStat1 = new GameStat(1L,
                1L,
                1L,
                1,
                1,
                1L);
        GameStat gameStat2 = new GameStat(1L,
                1L,
                1L,
                1,
                1,
                1L);
        List<GameStat> listGameStats = new ArrayList<>();
        listGameStats.add(gameStat1);
        listGameStats.add(gameStat2);
        when(gameStatRepository.findAll()).thenReturn(listGameStats);

       mockMvc.perform(get("/gamestats/")
               .contentType(MediaType.APPLICATION_JSON)
               .characterEncoding("UTF-8"))
               .andDo(print())
               .andExpect(status().isOk());

    }

    @Test
    public void newGameStat() throws Exception{
        GameStat gameStat1 = new GameStat(1L,
                1L,
                1L,
                1,
                1,
                1L);

        MockHttpServletResponse response = mockMvc.perform(
                post("/gamestats/").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(
                        jsonGameScore.write(gameStat1).getJson()
                ))

                .andDo(print())
                .andReturn()
                .getResponse();

       assertEquals(HttpStatus.OK.value(), response.getStatus());


    }

    @Test
    public void getOne() throws Exception {

        GameStat gameStat1 = new GameStat(1L,
                1L,
                1L,
                1,
                1,
                1L);
        when(gameStatRepository.findById(gameStat1.getId())).thenReturn(Optional.of(gameStat1));


        mockMvc.perform(get("/gamestats/").param("id", "1"))
                .andDo(print())

                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void replaceGameStats() {
    }

    @Test
    public void deleteGameStats() throws Exception {
        GameStat gameStat = new GameStat(1L,
                1L,
                1L,
                1,
                1,
                1L);

        when(gameStatRepository.findById(1L)).thenReturn(Optional.of(gameStat));

        mockMvc.perform(MockMvcRequestBuilders.delete("/gamestats/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}