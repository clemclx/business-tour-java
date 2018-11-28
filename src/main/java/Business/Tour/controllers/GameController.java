package Business.Tour.controllers;

import Business.Tour.models.GameScore;
import Business.Tour.models.GameStat;
import Business.Tour.services.GameScoreService;
import Business.Tour.services.GameService;
import Business.Tour.services.GameStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {
    @Autowired
    GameService gameService;

    @RequestMapping("/ratioWL/{id}")
    ResponseEntity getRatioWL(@PathVariable Long id) {

        return gameService.getRatioWL(id);
    }

    @RequestMapping("/averageDuration/{id}")
    ResponseEntity getAvgDuration(@PathVariable Long id){
        return gameService.getAvgDuration(id);
    }

    @RequestMapping("/averageMoneyEarned/{id}")
    ResponseEntity getAvgMoney(@PathVariable Long id){
        return gameService.getAvgMoneyEarned(id);
    }

    @RequestMapping("/gameStatsUpdated/{id}")
    ResponseEntity updatedGameStats(@PathVariable Long id){
        return gameService.getUpdatedGameStats(id);
    }
}
