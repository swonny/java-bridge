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

    public BridgeGame(List<String> availableSquares) {
        this.bridge = new Bridge(availableSquares);
        this.player = new Player();
        this.trial = 0;
    }

    private GameStatus move() {
        player.moveForward();
        System.out.println(bridge.getLastIndex());
        System.out.println(player.getCurrentPosition());
        if (bridge.getLastIndex() == player.getCurrentPosition()) {
            return GameStatus.SUCCESS;
        }
        return GameStatus.CONTINUE;
    }

    public GameStatus tryMoveTo(String squareToMove) {
        addTrial();
        if (canMoveTo(squareToMove)) {
            return move();
        }
        return GameStatus.FAILURE;
    }

    private void addTrial() {
        this.trial++;
    }

    private boolean canMoveTo(String squareToMove) {
        return bridge.isNextAvailable(squareToMove, player.getCurrentPosition());
    }

    public void retry() {
        player = new Player();
    }
}
