package constant;

import java.util.Arrays;

public enum RetryCommand {
    RETRY("R"),
    QUIT("Q");

    private final String retryCommand;

    RetryCommand(String retryCommand) {
        this.retryCommand = retryCommand;
    }

    public static RetryCommand getRetryCommandByCommand(String command) {
        return Arrays.stream(RetryCommand.values())
                .filter(retry -> retry.retryCommand.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("R 또는 Q 중에 입력하세요."));
    }
}
