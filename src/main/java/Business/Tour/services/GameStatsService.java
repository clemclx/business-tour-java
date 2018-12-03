package Business.Tour.services;

import Business.Tour.clients.IGameStatClient;
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
public class GameStatsService {
    private IGameStatClient iGameStatClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGameStatClient.class, "http://localhost:8081/");

    public ResponseEntity getOneGame(Long id) {
        log.info("Call to the CourseStudent composite getOneById : " + id);
        Object response =  iGameStatClient.getOneGameStats(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity getAll() {
        log.info("getAll gamestats");
        Object response = iGameStatClient.getAll();
        return  new ResponseEntity(response, HttpStatus.OK);
    }

    public ResponseEntity create(Object gameStat){
        log.info("create gamestat" + gameStat);
        Object response = iGameStatClient.create(gameStat);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity addScore(Long id, Object gameScore){
        log.info("addScore"+gameScore);
        Object response = iGameStatClient.addScore(id, gameScore);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
