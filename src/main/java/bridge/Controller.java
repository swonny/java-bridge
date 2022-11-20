package bridge;

import enumCollections.GameStatus;
import enumCollections.GuideMessage;
import enumCollections.Position;

public class Controller {
    OutputView outputView;
    InputView  inputView;

    public Controller(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void startGame(BridgeGame bridgeGame) {
        bridgeGame.generateBridge(getBridgeSize());
        GameStatus gameResult = play(bridgeGame, GameStatus.CONTINUE);
        getResult(gameResult, bridgeGame);
    }

    private int getBridgeSize() {
        new OutputView().printGuideMessage(GuideMessage.START);
        return this.inputView.readBridgeSize();
    }

    public GameStatus play(BridgeGame bridgeGame, GameStatus gameStatus) {
        Map map = new Map();
        while (gameStatus == GameStatus.CONTINUE) {
            gameStatus = bridgeGame.tryMoveTo(getMoving());
            if (gameStatus == GameStatus.FAILURE) {
                gameStatus = askRepeatGame(gameStatus, bridgeGame);
            }
            addMap(
                    map,
                    bridgeGame.getAvailableSquare(bridgeGame.getCurrentPosition()),
                    gameStatus
            );
        }
        return gameStatus;
    }

    private String getMoving() {
        outputView.printGuideMessage(GuideMessage.GET_MOVING);
        return inputView.readMoving();
    }

    private GameStatus askRepeatGame(GameStatus gameStatus, BridgeGame bridgeGame) {
        outputView.printAskGameCommand();
        if (inputView.readGameCommand() == GameStatus.getMessage(GameStatus.RESTART)) {
            bridgeGame.retry();
            return GameStatus.CONTINUE;
        }
        return GameStatus.FAILURE;
    }

    private void getResult(GameStatus gameResult, BridgeGame bridgeGame) {
        outputView.printResult(gameResult);
    }

    private void addMap(Map map, Position availableSide, GameStatus gameStatus) {
        map.add(availableSide, gameStatus);
        outputView.printMap(map);
    }
}
