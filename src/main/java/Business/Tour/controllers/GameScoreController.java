package Business.Tour.controllers;

import Business.Tour.entities.GameScore;
import Business.Tour.exceptions.GameScoreNotFoundException;
import Business.Tour.repositories.GameScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameScoreController {
    @Autowired
    private GameScoreRepository gameScoreRepository;

    @GetMapping("/gamescores")
    List<GameScore> getAll(){
        return gameScoreRepository.findAll();
    }

    @RequestMapping(value ="/gamescores", method = RequestMethod.POST)
    GameScore newGameScore(@ModelAttribute GameScore newGameScore){
        return gameScoreRepository.save(newGameScore);
    }

    @RequestMapping(value ="/gamescores/{id}", method = RequestMethod.GET)
    GameScore getOne(@PathVariable Long id){
        return gameScoreRepository.findById(id).orElseThrow(() -> new GameScoreNotFoundException(id));
    }

    @PutMapping("/gamescores/{id}")
    GameScore replaceGameScore(@RequestBody GameScore newGameScore, @PathVariable Long id) {
        return gameScoreRepository.findById(id).map(gameScore -> {
            gameScore.setId(newGameScore.getId());
            gameScore.setIdUser(newGameScore.getIdUser());
            gameScore.setMoneyEarned(newGameScore.getMoneyEarned());
            gameScore.setNbOfPropertiesBought(newGameScore.getMoneyEarned());
            gameScore.setNbTurns(newGameScore.getNbTurns());
            gameScore.setTotalDuration(newGameScore.getTotalDuration());
            return gameScoreRepository.save(gameScore);
        }).orElseGet(()-> {
            newGameScore.setId(id);
            return  gameScoreRepository.save(newGameScore);
        });
    }

    @DeleteMapping("/gamescores/{id}")
    void deleteGameScore (@PathVariable Long id){
        gameScoreRepository.deleteById(id);
    }

}
