package bridge.enums;

public enum Side {
    UP(1, "U"),
    DOWN(2, "D");

    private int matchingRandomNumber;
    private String bridgeSavingFormat;

    Side(int matchingRandomNumber, String bridgeSavingFormat) {
        this.matchingRandomNumber = matchingRandomNumber;
        this.bridgeSavingFormat = bridgeSavingFormat;
    }

    public static String getBridgeSavingFormat(int number) {
        if (number == UP.matchingRandomNumber) {
            return UP.bridgeSavingFormat;
        }
        return DOWN.bridgeSavingFormat;
    }
}
