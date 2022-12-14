package constant;

public enum Status {
    EMPTY(" ", ""), // 성공도, 실패도 아닌 경우
    SUCCESS("O", "성공"),
    FAIL("X", "실패");

    private final String view;
    private final String statusName;

    Status(String view, String statusName) {
        this.view = view;
        this.statusName = statusName;
    }

    public String getView() {
        return this.view;
    }

    public String getStatusName() {
        return this.statusName;
    }
}
