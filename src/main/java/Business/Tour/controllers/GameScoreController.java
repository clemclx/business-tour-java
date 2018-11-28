package Business.Tour.controllers;

import Business.Tour.models.GameScore;
import Business.Tour.models.GameStat;
import Business.Tour.services.GameScoreService;
import Business.Tour.services.GameStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameScoreController {
    @Autowired
    GameScoreService gameScoreService;

    @RequestMapping("/score/{id}")
    ResponseEntity getOne(@PathVariable Long id) {

        return gameScoreService.getOneGame(id);
    }

    @RequestMapping("/score")
    ResponseEntity getAll(){
        return gameScoreService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value="/score")
    ResponseEntity createGameScore(@ModelAttribute GameScore gameScore ){
        return gameScoreService.createGameScore(gameScore);
    }
}