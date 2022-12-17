package constant;

import java.util.Arrays;

public enum Side {
    UP("U", 1),
    DOWN("D", 0);

    private final String name;
    private final int generatingNumber;

    Side(String sideName, int generatingNumber) {
        this.name = sideName;
        this.generatingNumber = generatingNumber;
    }


    public static Side getSideByName(String sideName) {
        return Arrays.stream(Side.values())
                .filter(side -> side.name.equals(sideName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("U 또는 D 중 입력하세요."));
    }
}
