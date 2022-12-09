package bridge.controller;

import bridge.BridgeGame;
import bridge.ResultGenerator;
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
        playRound();
    }

    private void playRound() {
        while (!bridgeGame.isWin()) {
            movePlayer();
            printProgress();
            if (bridgeGame.isFailure() && willRetry()) {
                // TODO : 게임 실패 & 종료인 경우 수정 필요
                bridgeGame.retry();
            }
        }
        printResult(bridgeGame.getFinalResult(new ResultGenerator()));
    }

    private void printResult(String result) {
        OutputView.printResult(result);
    }

    private boolean willRetry() {
        OutputView.printReadRetry();
        try {
            return InputView.readGameCommand().equals(RESTART);
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            return willRetry();
        }
    }

    private void printProgress() {
        OutputView.printMap(bridgeGame.getMovingMap());
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
