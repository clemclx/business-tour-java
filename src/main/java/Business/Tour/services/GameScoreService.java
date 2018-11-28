package Business.Tour.services;

import Business.Tour.clients.IGameScoreClient;
import Business.Tour.clients.IGameStatClient;
import Business.Tour.models.GameScore;
import Business.Tour.models.GameStat;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
@Slf4j
public class GameScoreService {
    private IGameScoreClient iGameScoreClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGameScoreClient.class, "http://localhost:8080/");

    public ResponseEntity getOneGame(Long id) {
        log.info("Call to the CourseStudent composite getOneById : " + id);
        Object response =  iGameScoreClient.getOneGameScore(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity getAll() {
        log.info("getAll gamestats");
        Object response = iGameScoreClient.getAll();
        return  new ResponseEntity(response, HttpStatus.OK);
    }

    public ResponseEntity createGameScore(@ModelAttribute GameScore gameScore){
        log.info("create gamescore");
        Object response = iGameScoreClient.createGameScore(gameScore);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}