package view;

import constant.Side;
import constant.Status;

import java.util.List;
import java.util.stream.Collectors;

import static constant.ViewMessage.*;

public class OutputView {
    public static void printStartGame() {
        printLine(START_GAME);
        printNewLine();
    }

    public static void printLine(String value) {
        System.out.println(value);
    }

    private static void printNewLine() {
        System.out.println();
    }

    public static void printReadingBridgeSize() {
        printLine(READ_BRIDGE_SIZE);
        printNewLine();
    }

    public static void printExceptionMessage(Exception exception) {
        printException(exception.getMessage());
    }

    private static void printException(String message) {
        printLine("[ERROR] " + message);
    }

    public static void printReadingMovingSide() {
        printNewLine();
        printLine(READ_MOVING_SIDE);
    }

    public static void printReadingRetryCommand() {
        printLine(READ_RETRY_COMMAND);
    }

    public static void printResultMap(List<List<Status>> resultMap) {
        // TODO: 메소드 분리해보기 & 출력 형식 status/side/String 중에 결정해야함
        List<String> upResult = resultMap.get(Side.UP.getMapIndex()).stream()
                .map(status -> status.getView())
                .collect(Collectors.toList());
        List<String> downResult = resultMap.get(Side.DOWN.getMapIndex()).stream()
                .map(status -> status.getView())
                .collect(Collectors.toList());
        printMap(upResult);
        printMap(downResult);
    }

    private static void printMap(List<String> map) {
        print(BRIDGE_START);
        print(map.stream().collect(Collectors.joining(BRIDGE_DELIMITER)));
        printLine(BRIDGE_END);
        printNewLine();
    }

    private static void print(String value) {
        System.out.print(value);
    }

    public static void printFinalMap(List<List<Status>> resultMap) {
        printLine(FINAL_RESULT_TITLE);
        printResultMap(resultMap);
        printNewLine();
    }

    public static void printStatus(Status status, int trial) {
        printLine(FINAL_STATUS + status.getStatusName());
        printLine(TRIAL_COUNT + integerToString(trial));
    }

    private static String integerToString(int numericValue) {
        return Integer.toString(numericValue);
    }


}
