package enumCollections;

public enum GameStatus {
    CONTINUE(""),
    SUCCESS("성공"),
    FAILURE("실패"),
    QUIT("Q"),
    RESTART("R");

    private String message;

    GameStatus(String inputMessage) {
        this.message = inputMessage;
    }

    public static String getMessage(GameStatus gameStatus) {
        return gameStatus.message;
    }
}
