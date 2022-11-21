package view;

import camp.nextstep.edu.missionutils.Console;
import exceptionHandler.BridgeLengthException;
import exceptionHandler.InputException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        BridgeLengthException.validate(bridgeSize);
        return stringToInteger(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingSide = Console.readLine();
        InputException.validateSideSelection(movingSide);
        return movingSide;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine().trim();
        InputException.validateGameCommand(gameCommand);
        return gameCommand;
    }

    private int stringToInteger(String value) {
        return Integer.valueOf(value);
    }
}
