package controller;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import constant.RetryCommand;
import constant.Side;
import repository.ResultRepository;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private BridgeGame bridgeGame;

    public void run() {
        OutputView.printStartGame();
        Bridge bridge = makeBridge();
        this.bridgeGame = new BridgeGame(bridge);
        startBridgeGame();
        printFinalResult();
    }

    private void printFinalResult() {
        OutputView.printFinalMap(ResultRepository.getResultMap());
        OutputView.printStatus(ResultRepository.getStatus(), ResultRepository.getTrial());
    }

    private void startBridgeGame() {
        Side movingSide = getMovingSide(InputView.readMovingSide());
        boolean movedSuccessfully = bridgeGame.move(movingSide);
        ResultRepository.updateResult(movedSuccessfully, movingSide);
        OutputView.printResultMap(ResultRepository.getResultMap());
        if (movedSuccessfully && RetryCommand.QUIT.equals(getRetryCommand(InputView.readRetryCommand()))) {
            return;
        }
        if (bridgeGame.isWin()) {
            return;
        }
        startBridgeGame();
    }

    private boolean isGameFinished(boolean movedSuccessfully) {
        // TODO : 로직 정리하기
        // 게임이 졌는데 재시도 안한다면 끝 | 게임이 졌는데, 재시도 하면 초기화해야함
        if (!movedSuccessfully && RetryCommand.QUIT.equals(getRetryCommand(InputView.readRetryCommand()))) {
            return true;
        }
        // 게임이 안 졌는지
        return bridgeGame.isWin();
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

    private Bridge makeBridge() {
        // TODO : size ~ generate를 tryCatch하면 됨
        int bridgeSize = getBridgeSize(InputView.readBridgeSize());
        Bridge bridge = generateBridge(new BridgeMaker(new BridgeRandomNumberGenerator()), bridgeSize);
        return bridge;
    }

    private Bridge generateBridge(BridgeMaker bridgeMaker, int bridgeSize) {
        try {
            List<String> availableSideName = bridgeMaker.makeBridge(bridgeSize);
            List<Side> availableSide = getBridgeSide(availableSideName);
            return new Bridge(availableSide);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            // TODO : 브릿지 makeBridge()에서 숫자 유효성 & 길이 유효성 트라ㅋㅐ치 한번에 처리하기
            // TODO : return값 변경
            return null;
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
}
