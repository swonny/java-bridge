package bridge;

import bridge.enums.Side;

import java.util.List;

public class Bridge {
    private final List<String> movableSide;

    public Bridge(List<String> movableSide) {
        this.movableSide = movableSide;
    }

    public boolean isLastPosition(int position) {
        return getLastIndex() == position;
    }

    private int getLastIndex() {
        return movableSide.size() - 1;
    }

    public boolean isPlayerOnMovableSide(int currentPosition, Side movedSide) {
        return movedSide.equals(movableSide.get(currentPosition));
    }
}
