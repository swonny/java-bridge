package bridge.enums;

public enum GameStatus {
    CONTINUE("O", "성공"),
    FAIL("X", "실패"),
    SUCCESS("O", "성공");

    private String symbol;
    private String printFormat;

    GameStatus(String symbol, String printFormat) {
        this.symbol = symbol;
        this.printFormat = printFormat;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getPrintFormat() {
        return this.printFormat;
    }
}
