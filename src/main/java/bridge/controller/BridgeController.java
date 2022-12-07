package bridge.controller;

import bridge.BridgeGame;
import bridge.ResultGenerator;
import bridge.enums.GameStatus;
import view.InputView;
import view.OutputView;

public class BridgeController {
    private final String RESTART = "R";

    private final BridgeGame bridgeGame;

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
    }

    private boolean isRetry(String gameCommand) {
        return gameCommand.equals(RESTART);
    }

    private void playRound(GameStatus gameStatus) {
        while (!bridgeGame.isWin()) {
            movePlayer();
//            printProgress();
            if (bridgeGame.isFailure()) {
                askRetry();
            }
        }
        printResult(bridgeGame.getFinalResult(new ResultGenerator()));
    }

    private void printResult(String result) {
        OutputView.printResult(bridgeGame.toString());
    }

    private boolean askRetry() {
        OutputView.printReadRetry();
        try {
            return InputView.readGameCommand().equals(RESTART);
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            return askRetry();
        }
    }

//    private void printProgress() {
//        OutputView.printMap(bridgeGame.getBridgeMap());
//    }

    private void readBridgeSize() {
        OutputView.printReadBridgeSize();
        try {
            bridgeGame.makeBridge(InputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            readBridgeSize();
        }
    }

    private void movePlayer() {
        OutputView.printReadMovingSide();
        try {
            bridgeGame.move(InputView.readMoving());
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            movePlayer();
        }
    }
}
