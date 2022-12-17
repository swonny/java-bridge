package controller;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import constant.RetryCommand;
import constant.Side;
import exception.CommonException;
import repository.ResultRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BridgeController {
    private InputView inputView;
    private OutputView outputView;

    public BridgeController(OutputView outputView) {
        this.inputView = new InputView(outputView);
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        Bridge bridge = makeBridge(new BridgeMaker(new BridgeRandomNumberGenerator()));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean movedSuccessfully = movePlayer(bridgeGame);
        if (shouldContinue(movedSuccessfully, bridgeGame)) {
            movePlayer(bridgeGame);
        }
        outputView.printFinalResult(ResultRepository.getFinalResult());
    }

    private boolean shouldContinue(boolean movedSuccessfully, BridgeGame bridgeGame) {
        if (movedSuccessfully && bridgeGame.isFinished()) {
            return false;
        }
        return willRetry(inputView.readGameCommand());
    }

    private boolean willRetry(String gameCommand) {
        try {
            RetryCommand retryCommand = RetryCommand.getRetryCommandByInput(gameCommand);
            return RetryCommand.RETRY.equals(retryCommand);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return willRetry(inputView.readGameCommand());
        }
    }

    private boolean movePlayer(BridgeGame bridgeGame) {
        try {
            Side movingSide = Side.getSideByName(inputView.readMoving());
            return bridgeGame.move(movingSide);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return movePlayer(bridgeGame);
        }
    }

    private Bridge makeBridge(BridgeMaker bridgeMaker) {
        try {
            int bridgeSize = getBridgeSize(inputView.readBridgeSize());
            List<String> availableSides = bridgeMaker.makeBridge(bridgeSize);
            return new Bridge(availableSides);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return makeBridge(bridgeMaker);
        }
    }

    private int getBridgeSize(String bridgeSize) {
        CommonException.validateNumericOnly(bridgeSize);
        return Integer.valueOf(bridgeSize);
    }
}
