package view;

import camp.nextstep.edu.missionutils.Console;
import view.exceptions.InputExceptions;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String bridgeSize = Console.readLine();
        InputExceptions.validateBridgeSize(bridgeSize);
        return Integer.valueOf(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String movingSide = Console.readLine();
        InputExceptions.validateMovingSide(movingSide);
        return movingSide;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String gameCommand = Console.readLine();
        InputExceptions.validateGameCommand(gameCommand);
        return gameCommand;
    }
}
