package bridge.enums;

public enum GameStatus {
    CONTINUE("O"),
    FAIL("X"),
    SUCCESS("O");

    private String symbol;

    GameStatus(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
