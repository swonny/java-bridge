package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeMap {
    private final String bridgeStart = "[ ";
    private final String bridgeEnd = " ]\n";
    private final String bridgeDelimiter = " | ";
    private final String EMPTY = " ";
    private List<List<String>> bridgeMap = new ArrayList<>(
            List.of(new ArrayList<>(), new ArrayList<>())
    );

    public void add(GameStatus gameStatus, Side lastMoving) {
        bridgeMap.get(lastMoving.getBridgeMapIndex())
                .add(gameStatus.getSymbol());
        bridgeMap.get(lastMoving.getOppositeSide().getBridgeMapIndex())
                .add(EMPTY);
    }

    public String getBridgeMap() {
        StringBuilder completeBridge = new StringBuilder();
        for (Side side : Side.values()) {
            completeBridge.append(bridgeStart);
            completeBridge.append(bridgeMap.get(side.getBridgeMapIndex()).stream()
                    .collect(Collectors.joining(bridgeDelimiter)));
            completeBridge.append(bridgeEnd);
        }
        return completeBridge.toString();
    }
}
