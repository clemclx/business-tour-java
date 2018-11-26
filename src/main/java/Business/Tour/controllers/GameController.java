package Business.Tour.controllers;

import Business.Tour.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class GameController {
    @Autowired
    GameService gameService;

    @RequestMapping("/game/{id}")
    ResponseEntity getOne(@PathVariable Long id) {

        return gameService.getOneGame(id);
    }
}
