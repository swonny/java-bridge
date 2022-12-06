package view.enums;

public enum GuideMessage {
    START_GAME("다리 건너기 게임을 시작합니다."),
    READ_BRIDE_SIZE("다리의 길이를 입력해주세요."),
    READ_MOVING_SIDE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    READ_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
