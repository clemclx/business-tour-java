package Business.Tour.models;

import lombok.Data;


@Data
public class GameScore {
    public GameScore(Long moneyEarned, Long nbOfPropertiesBought, Long totalDuration, Integer nbTurns, Long idUser) {
        this.moneyEarned = moneyEarned;
        this.nbOfPropertiesBought = nbOfPropertiesBought;
        this.totalDuration = totalDuration;
        this.nbTurns = nbTurns;
        this.idUser = idUser;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(Long moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public Long getNbOfPropertiesBought() {
        return nbOfPropertiesBought;
    }

    public void setNbOfPropertiesBought(Long nbOfPropertiesBought) {
        this.nbOfPropertiesBought = nbOfPropertiesBought;
    }

    public Long getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Long totalDuration) {
        this.totalDuration = totalDuration;
    }

    public Integer getNbTurns() {
        return nbTurns;
    }

    public void setNbTurns(Integer nbTurns) {
        this.nbTurns = nbTurns;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    private Long id;
    private Long moneyEarned;
    private Long nbOfPropertiesBought;
    private Long totalDuration;
    private Integer nbTurns;
    private Long idUser;

}
