package bridge;

import enumCollections.Side;
import exceptionHandler.SideSelectionException;

public class Player {
    private Side lastMovedSide;
    private int currentPosition;

    public Player(final int initializedPosition) {
        currentPosition = initializedPosition;
    }

    public void move(String movingSide) {
        validate(movingSide);
        lastMovedSide = Side.get(movingSide);
        currentPosition++;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getLastMoving() {
        return lastMovedSide.getBridgeSavingFormat();
    }

    private void validate(String movableSide) {
        SideSelectionException.validate(movableSide);
    }
}