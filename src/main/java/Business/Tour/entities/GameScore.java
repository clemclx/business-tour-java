package Business.Tour.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class GameScore {
    public GameScore(Long moneyEarned, Long nbOfPropertiesBought, Long totalDuration, Integer nbTurns, Long idUser) {
        this.moneyEarned = moneyEarned;
        this.nbOfPropertiesBought = nbOfPropertiesBought;
        this.totalDuration = totalDuration;
        this.nbTurns = nbTurns;
        this.idUser = idUser;
    }

    public GameScore(Long id, Long moneyEarned, Long nbOfPropertiesBought, Long totalDuration, Integer nbTurns, Long idUser) {
        this.id=id;
        this.moneyEarned = moneyEarned;
        this.nbOfPropertiesBought = nbOfPropertiesBought;
        this.totalDuration = totalDuration;
        this.nbTurns = nbTurns;
        this.idUser = idUser;
    }

    private @Id
    @GeneratedValue
    Long id;
    private Long moneyEarned;
    private Long nbOfPropertiesBought;
    private Long totalDuration;
    private Integer nbTurns;
    private Long idUser;

    public GameScore(){

    }
}