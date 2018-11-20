package Business.Tour.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class GameScore {
    public GameScore(Long moneyEarned, Long nbOfPropertiesBought, Long totalDuration, Integer nbTurns, Long idUser, Long gameStatId) {
        this.moneyEarned = moneyEarned;
        this.nbOfPropertiesBought = nbOfPropertiesBought;
        this.totalDuration = totalDuration;
        this.nbTurns = nbTurns;
        this.gameStatId=gameStatId;
        this.idUser = idUser;
    }

    private @Id
    @GeneratedValue
    Long id;
    private boolean isWin;
    private Long moneyEarned;
    private Long nbOfPropertiesBought;
    private Long totalDuration;
    private Integer nbTurns;
    private Long idUser;
    private Long gameStatId;

}
