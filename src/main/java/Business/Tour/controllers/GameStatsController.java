package Business.Tour.controllers;

import Business.Tour.models.GameStat;
import Business.Tour.services.GameStatsService;
import feign.Body;
import feign.Headers;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @RequestMapping(value ="/stats", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity createGameStat(@RequestBody Object gameStat){
        return gameStatsService.create(gameStat);
    }

    @RequestMapping(value="/addScore/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity addScore(@PathVariable Long id, Object gameScore){
        return gameStatsService.addScore(id, gameScore);
    }
}
