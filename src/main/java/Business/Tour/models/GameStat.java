package Business.Tour.models;

import lombok.Data;


@Data
public class GameStat {
    public GameStat(Long nbWins, Long nbLoses, Long averageDurationOfGames, Integer totalMoneyEarned, Integer nbTotalGamesPlayed, Long idUser) {
        this.nbWins = nbWins;
        this.nbLoses = nbLoses;
        this.averageDurationOfGames = averageDurationOfGames;
        this.totalMoneyEarned = totalMoneyEarned;
        this.nbTotalGamesPlayed = nbTotalGamesPlayed;
        this.idUser = idUser;
    }

    public GameStat() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNbWins() {
        return nbWins;
    }

    public void setNbWins(Long nbWins) {
        this.nbWins = nbWins;
    }

    public Long getNbLoses() {
        return nbLoses;
    }

    public void setNbLoses(Long nbLoses) {
        this.nbLoses = nbLoses;
    }

    public Long getAverageDurationOfGames() {
        return averageDurationOfGames;
    }

    public void setAverageDurationOfGames(Long averageDurationOfGames) {
        this.averageDurationOfGames = averageDurationOfGames;
    }

    public Integer getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public void setTotalMoneyEarned(Integer totalMoneyEarned) {
        this.totalMoneyEarned = totalMoneyEarned;
    }

    public Integer getNbTotalGamesPlayed() {
        return nbTotalGamesPlayed;
    }

    public void setNbTotalGamesPlayed(Integer nbTotalGamesPlayed) {
        this.nbTotalGamesPlayed = nbTotalGamesPlayed;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    private Long id;
    private Long nbWins;
    private Long nbLoses;
    private Long averageDurationOfGames;
    private Integer totalMoneyEarned;
    private Integer nbTotalGamesPlayed;
    private Long idUser;
}
