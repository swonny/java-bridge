package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int INITIALIZED_POSITION = -1;
    private final int INITIALIZED_TRIAL = 1;
    private ProgressBoard progressBoard;
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

    public void move(String side) {
        player.move(Side.getBridgeSavingFormat(side));
        updateScoreBoard();
    }

    public void retry() {
        player = new Player(INITIALIZED_POSITION);
        progressBoard.retry();
    }

    public int getPlayerPosition() {
        return player.getCurrentPosition();
    }

    public void updateScoreBoard() {
        progressBoard.update(getGameStatus(), player.getLastMoving());
    }

    public GameStatus getGameStatus() {
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

    public String getBridgeMap() {
        return progressBoard.getBridgeMap();
    }

    public String getResult() {
        return progressBoard.getResult();
    }
}
