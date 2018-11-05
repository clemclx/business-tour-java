package Business.Tour.exceptions;

public class GameScoreNotFoundException extends RuntimeException {
    public GameScoreNotFoundException(Long id) {
        super("Could not find gamescore " + id );
    }
}
