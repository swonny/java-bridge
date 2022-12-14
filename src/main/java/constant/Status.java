package constant;

public enum Status {
    CONTINUE("", true),
    SUCCESS("성공", true),
    FAIL("실패", false);

    private final String statusName;
    private final boolean isSuccess;

    Status(String statusName, boolean isSuccess) {
        this.statusName = statusName;
        this.isSuccess = isSuccess;
    }

    public static Status getStatus(boolean movedSuccessfully) {
        if (movedSuccessfully) {
            return SUCCESS;
        }
        return FAIL;
    }

    public String getStatusName() {
        return this.statusName;
    }
}
