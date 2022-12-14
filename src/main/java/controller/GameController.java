package controller;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import constant.RetryCommand;
import constant.Side;
import constant.Status;
import repository.ResultRepository;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private BridgeGame bridgeGame;

    public void run() {
        OutputView.printStartGame();
        Bridge bridge = generateBridge(new BridgeMaker(new BridgeRandomNumberGenerator()));
        this.bridgeGame = new BridgeGame(bridge);
        ResultRepository.initialize();
        startBridgeGame();
        printFinalResult();
    }

    private void startBridgeGame() {
        startRound();
        if (ResultRepository.isFail() && RetryCommand.RETRY.equals(getRetryCommand(InputView.readRetryCommand()))) {
            ResultRepository.retry();
            bridgeGame.retry();
            startBridgeGame();
        }
    }

    private void startRound() {
        Side movingSide = getMovingSide(InputView.readMovingSide());
        boolean movedSuccessfully = bridgeGame.move(movingSide);
        ResultRepository.updateResult(movedSuccessfully, movingSide);
        OutputView.printResultMap(ResultRepository.getResultMap());
        if (!movedSuccessfully || isFinished()) {
            return;
        }
        startRound();
    }

    private boolean isFinished() {
        if (bridgeGame.isFinished()) {
            ResultRepository.updateStatus(Status.SUCCESS);
            return true;
        }
        return false;
    }

    private RetryCommand getRetryCommand(String input) {
        try {
            return RetryCommand.getRetryCommandByCommand(input);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return getRetryCommand(InputView.readRetryCommand());
        }
    }

    private Side getMovingSide(String movingSide) {
        try {
            return Side.getSideBySideName(movingSide);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return getMovingSide(InputView.readMovingSide());
        }
    }

    private Bridge generateBridge(BridgeMaker bridgeMaker) {
        try {
            int bridgeSize = getBridgeSize(InputView.readBridgeSize());
            List<String> availableSideName = bridgeMaker.makeBridge(bridgeSize);
            List<Side> availableSide = getBridgeSide(availableSideName);
            return new Bridge(availableSide);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            // TODO : 브릿지 makeBridge()에서 숫자 유효성 & 길이 유효성 트라ㅋㅐ치 한번에 처리하기
            return generateBridge(bridgeMaker);
        }
    }

    private List<Side> getBridgeSide(List<String> availableSideName) {
        return availableSideName.stream()
                .map(side -> Side.getSideBySideName(side))
                .collect(Collectors.toList());
    }

    private int getBridgeSize(String bridgeSize) {
        if (bridgeSize.matches("[0-9]+")) {
            return Integer.valueOf(bridgeSize);
        }
        OutputView.printExceptionMessage(new IllegalArgumentException("숫자를 입력해주세요."));
        return getBridgeSize(InputView.readBridgeSize());
    }

    private void printFinalResult() {
        OutputView.printFinalMap(ResultRepository.getResultMap());
        OutputView.printStatus(ResultRepository.getStatus(), ResultRepository.getTrial());
    }
}
