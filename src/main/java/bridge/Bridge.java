package bridge;

import constant.Side;

import java.util.List;

public class Bridge {
    private final List<Side> availableSide;

    public Bridge(List<Side> availableSide) {
        // TODO : validateSize 메소드추가
        this.availableSide = availableSide;
    }

    public boolean isAvailableToMove(Side side, int positionIndex) {
        return availableSide.get(positionIndex).equals(side);
    }

    public boolean isOnLastIndex(int positionIndex) {
        return availableSide.size() - 1 == positionIndex;
    }
}
