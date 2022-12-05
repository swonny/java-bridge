package bridge;

import enumCollections.Side;
import exceptionHandler.SideSelectionException;

public class Player {
    private Side lastMovedSide;
    private int currentPositionIndex;

    public Player(final int INITIALIZED_POSITION) {
        currentPositionIndex = INITIALIZED_POSITION;
    }

    public void move(String movingSide) {
        validate(movingSide);
        lastMovedSide = Side.get(movingSide);
        currentPositionIndex++;
    }

    public int getCurrentPositionIndex() {
        return currentPositionIndex;
    }

    public String getLastMoving() {
        return lastMovedSide.getBridgeSavingFormat();
    }

    private void validate(String movableSide) {
        SideSelectionException.validate(movableSide);
    }
}