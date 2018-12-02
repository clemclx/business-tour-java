package Business.Tour.controllers;

import Business.Tour.models.GameStat;
import Business.Tour.services.GameStatsService;
import feign.Body;
import feign.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameStatsController {
    @Autowired
    GameStatsService gameStatsService;

    @RequestMapping("/stats/{id}")
    ResponseEntity getOne(@PathVariable Long id) {

        return gameStatsService.getOneGame(id);
    }

    @RequestMapping("/stats")
    ResponseEntity getAll(){
        return gameStatsService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value="/stats/")
    ResponseEntity createGameStat(@ModelAttribute GameStat gameStat ){
        return gameStatsService.create(gameStat);
    }
}
