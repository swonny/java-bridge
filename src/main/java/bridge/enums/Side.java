package bridge.enums;

public enum Side {
    UP(1),
    DOWN(2);

    private int matchingRandomNumber;

    Side(int matchingRandomNumber) {
        this.matchingRandomNumber = matchingRandomNumber;
    }
}
