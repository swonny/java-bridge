package bridge;

import constant.Side;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int INITIALIZED_POSITION_INDEX = -1;
    private final Bridge bridge;
    private int positionIndex;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.positionIndex = INITIALIZED_POSITION_INDEX;
    }

    public boolean move(Side side) {
        movePositionIndex();
        return bridge.isAvailableToMove(side, positionIndex);
    }

    private void movePositionIndex() {
        positionIndex++;
    }

    public void retry() {
        positionIndex = INITIALIZED_POSITION_INDEX;
    }

    public boolean isFinished() {
        return bridge.isOnLastIndex(positionIndex);
    }
}
