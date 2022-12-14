package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readBridgeSize() {
        OutputView.printReadingBridgeSize();
        return read();
    }

    private static String read() {
        return Console.readLine();
    }

    public static String readMovingSide() {
        OutputView.printReadingMovingSide();
        return read();
    }

    public static String readRetryCommand() {
        OutputView.printReadingRetryCommand();
        return read();
    }
}
