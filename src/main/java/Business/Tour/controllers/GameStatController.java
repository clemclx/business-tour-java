package Business.Tour.controllers;

import Business.Tour.entities.GameStat;
import Business.Tour.exceptions.GameStatNotFoundException;
import Business.Tour.repositories.GameStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameStatController {
    @Autowired
    private GameStatRepository gameStatRepository;

    @GetMapping("/gamestats")
    List<GameStat> getAll(){
        return gameStatRepository.findAll();
    }

    @RequestMapping(value ="/gamestats", method = RequestMethod.POST)
    GameStat newGameStat(@ModelAttribute GameStat newGameStat){
        return gameStatRepository.save(newGameStat);
    }

    @RequestMapping(value ="/gamestats/{id}", method = RequestMethod.GET)
    GameStat getOne(@PathVariable Long id){
        return gameStatRepository.findById(id).orElseThrow(() -> new GameStatNotFoundException(id));
    }

    @PutMapping("/gamestats/{id}")
    GameStat replaceGameStat(@ModelAttribute GameStat newGameStat, @PathVariable Long id) {
        return gameStatRepository.findById(id).map(gameStat -> {
            gameStat.setId(newGameStat.getId());
            gameStat.setIdUser(newGameStat.getIdUser());
            gameStat.setNbLoses(newGameStat.getNbLoses());
            gameStat.setNbWins(newGameStat.getNbWins());
            gameStat.setAverageDurationOfGames(newGameStat.getAverageDurationOfGames());
            gameStat.setTotalMoneyEarned(newGameStat.getTotalMoneyEarned());
            gameStat.setNbTotalGamesPlayed(newGameStat.getNbTotalGamesPlayed());
            return gameStatRepository.save(gameStat);
        }).orElseGet(()-> {
            newGameStat.setId(id);
            return  gameStatRepository.save(newGameStat);
        });
    }

    @DeleteMapping("/gamestats/{id}")
    void deleteGameStat (@PathVariable Long id){
        gameStatRepository.deleteById(id);
    }

    @PutMapping("/gamestat/{id}")
    int changeGameStat(@ModelAttribute GameStat newGame, @PathVariable  Long id){
        return gameStatRepository.updateGameStats(id);
    }

    @GetMapping("/gamestats/nbWins/{id}")
    Long getOneNbWins(@PathVariable Long id){
        return gameStatRepository.getOneNbWins(id).orElseThrow(() -> new GameStatNotFoundException(id));
    }
    @GetMapping("/gamestats/nbLoses/{id}")
    Long getOneNbLoses(@PathVariable Long id){
        return gameStatRepository.getOneNbLoses(id).orElseThrow(() -> new GameStatNotFoundException(id));
    }
    @GetMapping("/gamestats/nbGames/{id}")
    Long getOneNbGames(@PathVariable Long id){
        return gameStatRepository.getOneNbGames(id).orElseThrow(() -> new GameStatNotFoundException(id));
    }
    @GetMapping("/gamestats/moneyEarned/{id}")
    Integer getOneMoneyEarned(@PathVariable Long id){
        return gameStatRepository.getOneTotalMoneyEarned(id).orElseThrow(() -> new GameStatNotFoundException(id));
    }
}
