package bridge;

import enumCollections.GameStatus;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private Player player;
    private int trial;

    public BridgeGame(int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        this.player = new Player();
        this.trial = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private GameStatus move() {
        player.moveForward();
        if (bridge.getLastIndex() == player.getCurrentPosition()) {
            return GameStatus.SUCCESS;
        }
        return GameStatus.CONTINUE;
    }

    public GameStatus tryMoveTo(String squareToMove) {
        if (canMoveTo(squareToMove)) {
            return move();
        }
        return GameStatus.FAILURE;
    }

    private boolean canMoveTo(String squareToMove) {
        return bridge.isNextAvailable(squareToMove, player.getCurrentPosition());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
