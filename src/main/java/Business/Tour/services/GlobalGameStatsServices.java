package Business.Tour.services;

import Business.Tour.clients.IGameScoreClient;
import Business.Tour.clients.IGameStatsClient;
import Business.Tour.models.GameScore;
import Business.Tour.models.GameStats;
import Business.Tour.models.GameStatsUpdated;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GlobalGameStatsServices {

    private IGameScoreClient iGameScoreClient = new Feign.Builder().client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGameScoreClient.class, "http://localhost:8080/gamescores");

    private IGameStatsClient iGameStatsClient = new Feign.Builder().client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGameStatsClient.class, "http://localhost:8081/gamestats");

    public GameStatsUpdated getOneById(Long gameStatId){

        log.info("Call to the GameStat core - getOneById : " + gameStatId);
        GameStats gameStats = iGameStatsClient.getOneById(gameStatId);

        log.info("Call to the GameScore core - getAllByGameStatId : " + gameStatId);
        List<GameScore> gameScores = iGameScoreClient.getAllByGameStatId(gameStatId);

        return new GameStatsUpdated(gameStats.getId(), gameStats.getAverageDurationOfGames(), gameScores);
    }


    public Long getRatioWL(Long gameStatId) {
        GameStats gameStat = iGameStatsClient.getOneById(gameStatId);
        if(gameStat.getNbTotalGamesPlayed() == 0L)
        {
            return 0L;
        }
        return gameStat.getNbWins()/gameStat.getNbLoses();
    }

    public Long getAverageMoneyEarned(Long gameStatId) {
        GameStats gameStat = iGameStatsClient.getOneById(gameStatId);
        if(gameStat.getTotalMoneyEarned() == 0L)
        {
            return 0L;
        }
        return gameStat.getTotalMoneyEarned()/gameStat.getNbTotalGamesPlayed().longValue();
    }

    public Long getAverageDuration(Long gameStatId) {
        GameStats gameStat = iGameStatsClient.getOneById(gameStatId);
        if(gameStat.getAverageDurationOfGames() == 0L)
        {
            return 0L;
        }
        return gameStat.getAverageDurationOfGames()/gameStat.getNbTotalGamesPlayed();
    }
}
