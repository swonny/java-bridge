package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;
import net.bytebuddy.agent.builder.AgentBuilder;

public class ProgressBoard {
    private int trial;
    private GameStatus gameStatus;
    private BridgeMap bridgeMap;

    public ProgressBoard(int initializedTrial, GameStatus gameStatus) {
        trial = initializedTrial;
        this.gameStatus = gameStatus;
    }

    public void update(GameStatus gameStatus, Side lastMoving) {
        this.gameStatus = gameStatus;
        updateMap(gameStatus, lastMoving);
    }

    private void updateMap(GameStatus gameStatus, Side lastMoving) {
        bridgeMap.add(gameStatus, lastMoving);
    }
}
