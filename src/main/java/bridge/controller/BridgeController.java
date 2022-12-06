package bridge.controller;

import bridge.Bridge;
import bridge.BridgeGame;
import view.InputView;
import view.OutputView;

public class BridgeController {

    private BridgeGame brideGame;

    public BridgeController(BridgeGame bridgeGame) {
        this.brideGame = bridgeGame;
    }

    public void startGame() {
        OutputView.printStartMessage();
        readBridgeSize();
        readMovingSide();
        printProgress();
    }

    private void printProgress() {
        OutputView.printProgress(brideGame.getBridgeMap());
    }

    private void readBridgeSize() {
        OutputView.printReadBridgeSize();
        brideGame.makeBridge(InputView.readBridgeSize());
        readMovingSide();
    }

    private void readMovingSide() {
        OutputView.printReadMovingSide();
        brideGame.move(InputView.readMoving());
    }


}
