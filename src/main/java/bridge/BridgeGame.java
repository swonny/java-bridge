package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int INITIALIZED_POSITION = -1;
    private final int INITIALIZED_TRIAL = 1;
    private final ProgressBoard progressBoard;
    private Player player;
    private Bridge bridge;

    public BridgeGame() {
        player = new Player(INITIALIZED_POSITION);
        progressBoard = new ProgressBoard(INITIALIZED_TRIAL, GameStatus.CONTINUE);
    }

    public void makeBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public void move(Side up) {
        player.move(up);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public int getPlayerPosition() {
        return player.getCurrentPosition();
    }

    public void updateScoreBoard() {
        progressBoard.update(getGameStatus(), player.getLastMoving());
    }

    private GameStatus getGameStatus() {
        if (!isPlayerOnMovableSide(player.getCurrentPosition(), player.getLastMoving())) {
            return GameStatus.FAIL;
        }
        // TODO : 네이밍 is~ 보다 자연스러운 거 찾기
        return isGameFinished();
    }

    private GameStatus isGameFinished() {
        if (bridge.isLastPosition(player.getCurrentPosition())) {
            return GameStatus.SUCCESS;
        }
        return GameStatus.CONTINUE;
    }

    private boolean isPlayerOnMovableSide(int currentPosition, Side movedSide) {
        return bridge.isPlayerOnMovableSide(currentPosition, movedSide);
    }
}
