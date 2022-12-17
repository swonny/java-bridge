package constant;

import java.util.Arrays;

public enum RetryCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    RetryCommand(String command) {
        this.command = command;
    }

    public static RetryCommand getRetryCommandByInput(String input) {
        return Arrays.stream(RetryCommand.values())
                .filter(retryCommand -> retryCommand.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("R 또는 Q 중 입력하세요."));
    }
}
