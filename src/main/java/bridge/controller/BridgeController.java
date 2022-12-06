package bridge.controller;

import bridge.BridgeGame;
import bridge.enums.GameStatus;
import view.InputView;
import view.OutputView;

public class BridgeController {
    private final String QUIT = "Q";
    private final String RESTART = "R";

    private BridgeGame bridgeGame;

    public BridgeController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void startGame() {
        OutputView.printStartMessage();
        readBridgeSize();
        while (playRound(GameStatus.CONTINUE) == GameStatus.FAIL) {
            if (!isRetry(readGameCommand())) {
                break;
            }
            bridgeGame.retry();
        }
        printResult();
    }

    private void printResult() {
        OutputView.printResult(bridgeGame.getResult());
    }

    private boolean isRetry(String gameCommand) {
        return gameCommand.equals(RESTART);
    }

    private String readGameCommand() {
        OutputView.printReadRetry();
        try {
            return InputView.readGameCommand();
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            return readGameCommand();
        }
    }

    private GameStatus playRound(GameStatus gameStatus) {
        while (gameStatus == GameStatus.CONTINUE) {
            readMovingSide();
            printProgress();
            gameStatus = bridgeGame.getGameStatus();
        }
        return bridgeGame.getGameStatus();
    }

    private void printProgress() {
        OutputView.printMap(bridgeGame.getBridgeMap());
    }

    private void readBridgeSize() {
        OutputView.printReadBridgeSize();
        try {
            bridgeGame.makeBridge(InputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            readBridgeSize();
        }
    }

    private void readMovingSide() {
        OutputView.printReadMovingSide();
        try {
            bridgeGame.move(InputView.readMoving());
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            readMovingSide();
        }

    }
}
