package view;

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

}
