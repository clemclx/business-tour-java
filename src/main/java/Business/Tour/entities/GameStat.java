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
    private Long nbWins;
    private Long nbLoses;
    private Long averageDurationOfGames;
    private Integer totalMoneyEarned;
    private Integer nbTotalGamesPlayed;
    private Long idUser;

    public GameStat(){

    }
}
