package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;

public class BridgeGame {
    private final int INITIALIZED_POSITION = -1;
    private final int INITIALIZED_TRIAL = 1;

    private final ResultBoard resultBoard;
    private MovingMap movingMap;
    private Player player;
    private Bridge bridge;

    public BridgeGame() {
        player = new Player(INITIALIZED_POSITION);
        movingMap = new MovingMap();
        resultBoard = new ResultBoard(INITIALIZED_TRIAL, GameStatus.CONTINUE);
    }

    public void makeBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public void move(String side) {
        player.move(Side.getBridgeSavingFormat(side));
        resultBoard.updateResult(getGameStatus());
        movingMap.add(getGameStatus(), Side.getBridgeSavingFormat(side));
    }

    public void retry() {
        player = new Player(INITIALIZED_POSITION);
        resultBoard.retry();
        movingMap = new MovingMap();
    }

    public boolean isWin() {
        return bridge.isLastPosition(player.getCurrentPosition());
    }

    public boolean isFailure() {
        return bridge.isPlayerOnMovableSide(player.getCurrentPosition(), player.getLastMoving());
    }

    private GameStatus getGameStatus() {
        if (isFailure()) {
            return GameStatus.FAIL;
        }
        return GameStatus.SUCCESS;
    }

    public String getFinalResult(ResultGenerator resultGenerator) {
        return resultGenerator.get(movingMap.toString(), resultBoard.toString());
    }

    public String getMovingMap() {
        return movingMap.toString();
    }
}
