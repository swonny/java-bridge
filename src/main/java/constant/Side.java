package constant;

import java.util.Arrays;

public enum Side {
    UP("U", 0),
    DOWN("D", 1);

    private final String sideCommand;
    private final int mapIndex;

    Side(String sideCommand, int mapIndex) {
        this.sideCommand = sideCommand;
        this.mapIndex = mapIndex;
    }

    public static Side getSideBySideName(String movingSide) {
        return Arrays.stream(Side.values())
                .filter(side -> side.sideCommand.equals(movingSide))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("U 또는 D 중 입력하세요."));
    }

    public String getSideCommand() {
        return this.sideCommand;
    }

    public int getMapIndex() {
        return this.mapIndex;
    }
}
