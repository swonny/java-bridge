package bridge;

public class ResultGenerator {
    private static final String START_RESULT_MESSAGE = "최종 게임 결과";
    private static final String NEWLINE = "\n";

    public String get(String movingMap, String finalResult) {
        return START_RESULT_MESSAGE
                + NEWLINE
                + movingMap
                + finalResult;
    }
}
