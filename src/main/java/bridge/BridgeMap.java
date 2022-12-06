package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private final String EMPTY = " ";
    private List<List<String>> bridgeMap = new ArrayList<>(new ArrayList<>());

    public void add(GameStatus gameStatus, Side lastMoving) {
        if (gameStatus == GameStatus.FAIL) {
            bridgeMap.get(lastMoving.getBridgeMapIndex())
                    .add(gameStatus.getSymbol());
            bridgeMap.get(lastMoving.getOppositeSide().getBridgeMapIndex())
                    .add(EMPTY);
        }
    }
}
