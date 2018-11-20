package Business.Tour.controllers;

import Business.Tour.models.GameStats;
import Business.Tour.models.GameStatsUpdated;
import Business.Tour.services.GlobalGameStatsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GlobalGameStatsController {
    @Autowired
    GlobalGameStatsServices globalGameStatsServices;

    @RequestMapping("/gameStatsUpdated/{id}")
    ResponseEntity<GameStatsUpdated> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(globalGameStatsServices.getOneById(id), HttpStatus.OK);
    }

    @RequestMapping("/gameStats/kda/{id}")
    ResponseEntity<Long> getRatioWL(@PathVariable Long id) {
        return new ResponseEntity<Long>(globalGameStatsServices.getRatioWL(id), HttpStatus.OK);
    }



}
