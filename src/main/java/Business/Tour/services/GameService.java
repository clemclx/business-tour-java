package Business.Tour.services;

import Business.Tour.clients.IGameClient;
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
public class GameService {
    private IGameClient iGameClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGameClient.class, "http://localhost:8082/");

    public ResponseEntity getRatioWL(Long id) {
        Object response =  iGameClient.getRatioWL(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity getAvgDuration(Long id) {
        Object response = iGameClient.getAverageDuration(id);
        return  new ResponseEntity(response, HttpStatus.OK);
    }


    public ResponseEntity getAvgMoneyEarned(Long id) {
        Object response = iGameClient.getAverageMoneyEarned(id);
        return  new ResponseEntity(response, HttpStatus.OK);
    }

    public ResponseEntity getUpdatedGameStats(Long id) {
        Object response = iGameClient.getGameStatsUpdated(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}