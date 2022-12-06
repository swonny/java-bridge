package bridge;

import bridge.enums.Side;

public class Player {
    private int currentPosition;
    private Side lastMovedSide;

    public Player(int initializedPosition) {
        currentPosition = initializedPosition;
    }

    public void move(Side movedSide) {
        lastMovedSide = movedSide;
        currentPosition++;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Side getLastMoving() {
        return lastMovedSide;
    }
}
