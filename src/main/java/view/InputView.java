package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    private String read() {
        return Console.readLine();
    }

    public String readBridgeSize() {
        outputView.printReadingBridgeSize();
        return read();
    }

    public String readMoving() {
        outputView.printReadMoving();
        return read();
    }

    public String readGameCommand() {
        outputView.printReadingCommand();
        return read();
    }
}
