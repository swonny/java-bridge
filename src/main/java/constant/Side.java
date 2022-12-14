package constant;

import java.util.Arrays;
import java.util.List;

public enum Side {
    UP("U", 0, 1),
    DOWN("D", 1, 0);

    private final String sideCommand;
    private final int mapIndex;
    private final int generatingNumber;

    Side(String sideCommand, int mapIndex, int generatingNumber) {
        this.sideCommand = sideCommand;
        this.mapIndex = mapIndex;
        this.generatingNumber = generatingNumber;
    }

    public static Side getSideBySideName(String movingSide) {
        return Arrays.stream(Side.values())
                .filter(side -> side.sideCommand.equals(movingSide))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("U 또는 D 중 입력하세요."));
    }

    public static String getGeneratingNumber(int number) {
        return Arrays.stream(Side.values())
                .filter(side -> side.generatingNumber == number)
                .map(side -> side.sideCommand)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 숫자입니다."));
    }

    public String getSideCommand() {
        return this.sideCommand;
    }

    public int getMapIndex() {
        return this.mapIndex;
    }

    public Side getOppositeSide() {
        if (this.equals(UP)) {
            return DOWN;
        }
        return UP;
    }
}
