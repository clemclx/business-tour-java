package Business.Tour.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
public class GameStats {
    private @Id
    @GeneratedValue
    Long id;
    private Long nbWins;
    private Long nbLoses;
    private Long averageDurationOfGames;
    private Integer totalMoneyEarned;
    private Integer nbTotalGamesPlayed;
    private Long idUser;

    public GameStats(){

    }
}
