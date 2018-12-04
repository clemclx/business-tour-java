package Business.Tour.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "game_stat")
public class GameStat {

    private @Id
    @GeneratedValue
    Long id;

    public GameStat(Long nbWins, Long nbLoses, Long averageDurationOfGames, Integer totalMoneyEarned, Integer nbTotalGamesPlayed, Long idUser) {
        this.nbWins = nbWins;
        this.nbLoses = nbLoses;
        this.averageDurationOfGames = averageDurationOfGames;
        this.totalMoneyEarned = totalMoneyEarned;
        this.nbTotalGamesPlayed = nbTotalGamesPlayed;
        this.idUser = idUser;
    }

    private Long nbWins;
    private Long nbLoses;
    private Long averageDurationOfGames;
    private Integer totalMoneyEarned;
    private Integer nbTotalGamesPlayed;
    private Long idUser;

    public GameStat(){

    }
}
