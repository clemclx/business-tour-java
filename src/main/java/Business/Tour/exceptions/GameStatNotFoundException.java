package Business.Tour.exceptions;

public class GameStatNotFoundException extends RuntimeException {
    public GameStatNotFoundException(Long id) {
        super("Could not find gamestat" + id);
    }
}
