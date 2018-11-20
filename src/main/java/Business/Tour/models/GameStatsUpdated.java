package Business.Tour.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GameStatsUpdated {
    private Long id;
    private Long averageDurationOfGames;
    private List<GameScore> gameScores;
}
