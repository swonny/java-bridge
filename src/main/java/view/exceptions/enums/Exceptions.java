package view.exceptions.enums;

public enum Exceptions {
    OUT_OF_BRIDGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_SIDE("[ERROR] U또는 D 중 하나를 입력해야 합니다."),
    NOT_GAME_COMMAND("[ERROR] 재시도: R, 종료: Q 중 하나를 입력해야 합니다."),
    INCLUDE_CHARACTER("[ERROR] 문자는 입력할 수 없습니다.");

    private final String errorMessage;

    Exceptions(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String get() {
        return this.errorMessage;
    }
}
