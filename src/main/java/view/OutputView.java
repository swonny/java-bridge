package view;

import java.util.List;

import static constant.ViewMessage.*;

public class OutputView {
    private void println(String value) {
        System.out.println(value);
    }

    private void printNewLine() {
        System.out.println();
    }

    private String integerToString(int numericValue) {
        return Integer.toString(numericValue);
    }

    private void print(String value) {
        System.out.print(value);
    }

    private void printFormat(String value, String formatValue) {
        System.out.printf(value, formatValue);
    }

    public void printExceptionMessage(Exception exception) {
        println("[ERROR] " + exception.getMessage());
    }

    public void printInfo(String value) {
        println("[INFO] " + value);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStartMessage() {
        println(GAME_START_MESSAGE);
    }

    public void printReadingBridgeSize() {
        println(READ_BRIDGE_SIZE);
    }

    public void printFinalResult(List<String> finalResult) {
        // TODO : 최종 결과 출력 기능 구현 : 어떤 데이터 자료형을 넘겨줄지 생각해뵤기
        println(FINAL_RESULT_TITLE);
        // TODO : 브릿지 출력
        // TODO : 성고/실패 여부 출력
        // TODO : 시도횟수 출력
    }

    public void printReadMoving() {
        println(READ_MOVING_SIDE);
    }

    public void printReadingCommand() {
        println(READ_RETRY_COMMAND);
    }
}
