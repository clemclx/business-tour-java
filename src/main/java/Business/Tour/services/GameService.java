package Business.Tour.services;

import Business.Tour.clients.IGameClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GameService {
    private IGameClient iGameClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGameClient.class, "http://localhost:8082/game");
    public ResponseEntity getOneGame(Long id) {
        log.info("Call to the CourseStudent composite getOneById : " + id);
        return iGameClient.getOneById(id);
    }
}
