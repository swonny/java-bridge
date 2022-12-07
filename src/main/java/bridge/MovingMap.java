package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovingMap {
    private final String BRIDGE_START = "[ ";
    private final String BRIDGE_END = " ]\n";
    private final String BRIDGE_DELIMITER = " | ";
    private final String EMPTY = " ";
    private final List<List<String>> bridgeMap = new ArrayList<>(
            List.of(new ArrayList<>(), new ArrayList<>())
    );

    public void add(GameStatus gameStatus, Side lastMoving) {
        bridgeMap.get(lastMoving.getBridgeMapIndex())
                .add(gameStatus.getSymbol());
        bridgeMap.get(lastMoving.getOppositeSide().getBridgeMapIndex())
                .add(EMPTY);
    }

    @Override
    public String toString() {
        StringBuilder completeBridge = new StringBuilder();
        for (List<String> bridgeSide : bridgeMap) {
            completeBridge.append(BRIDGE_START);
            completeBridge.append(bridgeSide.stream().collect(Collectors.joining(BRIDGE_DELIMITER)));
            completeBridge.append(BRIDGE_END);
        }
        return completeBridge.toString();
    }
}
