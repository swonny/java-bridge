package bridge.enums;

public enum Side {
    UP(1, "U", 0),
    DOWN(2, "D", 1);

    private final int matchingRandomNumber;
    private final String bridgeSavingFormat;
    private final int bridgeMapIndex;

    Side(int matchingRandomNumber, String bridgeSavingFormat, int bridgeMapIndex) {
        this.matchingRandomNumber = matchingRandomNumber;
        this.bridgeSavingFormat = bridgeSavingFormat;
        this.bridgeMapIndex = bridgeMapIndex;
    }

    public static String getBridgeSavingFormat(int number) {
        if (number == UP.matchingRandomNumber) {
            return UP.bridgeSavingFormat;
        }
        return DOWN.bridgeSavingFormat;
    }

    public static Side getBridgeSavingFormat(String side) {
        if (UP.bridgeSavingFormat.equals(side)) {
            return Side.UP;
        }
        return Side.DOWN;
    }

    public boolean equals(String side) {
        return this.bridgeSavingFormat.equals(side);
    }

    public Side getOppositeSide() {
        if (this == UP) {
            return DOWN;
        }
        return UP;
    }

    public int getBridgeMapIndex() {
        return this.bridgeMapIndex;
    }

    @Override
    public String toString() {
        return this.bridgeSavingFormat;
    }
}
