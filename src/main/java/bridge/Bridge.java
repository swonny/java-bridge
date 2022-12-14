package bridge;

import constant.Side;

import java.util.List;

public class Bridge {
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;
    private final List<Side> availableSide;

    public Bridge(List<Side> availableSide) {
        // TODO : validateSize 메소드추가
        validate(availableSide);
        this.availableSide = availableSide;
    }

    private void validate(List<Side> availableSide) {
        if (availableSide.size() < MINIMUM_BRIDGE_SIZE || availableSide.size() > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException("다리 길이는 3 이상 20이하로 입력해주세요.");
        }
    }

    public boolean isAvailableToMove(Side side, int positionIndex) {
        return availableSide.get(positionIndex).equals(side);
    }

    public boolean isOnLastIndex(int positionIndex) {
        return availableSide.size() - 1 == positionIndex;
    }
}
