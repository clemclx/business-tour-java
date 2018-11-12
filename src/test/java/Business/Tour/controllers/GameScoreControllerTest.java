package Business.Tour.controllers;

import Business.Tour.entities.GameScore;
import Business.Tour.repositories.GameScoreRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static java.util.EnumSet.allOf;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.data.repository.util.ClassUtils.hasProperty;
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

    @MockBean
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
    public void getAll() throws Exception {
        GameScore gamescore1 = new GameScore(Long.valueOf(1000000), Long.valueOf(10), Long.valueOf(15), 15, Long.valueOf(1));
        GameScore gamescore2 = new GameScore(Long.valueOf(1000000), Long.valueOf(10), Long.valueOf(15), 15, Long.valueOf(1));

        when(gameScoreRepository.findAll()).thenReturn(Arrays.asList(gamescore1, gamescore2));

       mockMvc.perform(get("/gamescores/"))
               .andDo(print())

               .andExpect(status().isOk());
    }

    @Test
    public void newGameScore() throws Exception{
        GameScore gamescore1 = new GameScore(Long.valueOf(1000000), Long.valueOf(10), Long.valueOf(15), 15, Long.valueOf(1));

        MockHttpServletResponse response = mockMvc.perform(
                post("/gamescores/").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(
                        jsonGameScore.write(gamescore1).getJson()
                ))

                .andDo(print())
                .andReturn()
                .getResponse();

       assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

    @Test
    public void getOne() throws Exception {

        GameScore gamescore1 = new GameScore(1L,1000000L, 10L, 15L, 15, 1L);

        when(gameScoreRepository.getOne(gamescore1.getId())).thenReturn(gamescore1);


        mockMvc.perform(get("/gamescores/1"))
                .andDo(print())

                .andExpect(status().isOk());


    }

    @Test
    public void replaceGameScore() {
    }

    @Test
    public void deleteGameScore() {
    }
}