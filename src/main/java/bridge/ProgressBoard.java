package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;
import net.bytebuddy.agent.builder.AgentBuilder;

public class ProgressBoard {
    private final String NEW_LINE = "\n";
    private final String IS_WIN = "게임 성공 여부: ";
    private final String TRIAL = "총 시도한 횟수: ";
    private int trial;
    private GameStatus gameStatus;
    private BridgeMap bridgeMap;

    public ProgressBoard(int initializedTrial, GameStatus gameStatus) {
        trial = initializedTrial;
        bridgeMap = new BridgeMap();
        this.gameStatus = gameStatus;
    }

    public void update(GameStatus gameStatus, Side lastMoving) {
        this.gameStatus = gameStatus;
        updateMap(gameStatus, lastMoving);
    }

    private void updateMap(GameStatus gameStatus, Side lastMoving) {
        bridgeMap.add(gameStatus, lastMoving);
    }

    public String getBridgeMap() {
        return bridgeMap.getBridgeMap();
    }

    public String getResult() {
        StringBuffer result = new StringBuffer();
        result.append(bridgeMap.getBridgeMap());
        result.append(NEW_LINE);
        result.append(IS_WIN + gameStatus.getPrintFormat());
        result.append(NEW_LINE);
        result.append(TRIAL.concat(Integer.toString(trial)));

        return result.toString();
    }

    private void addTrial() {
        trial++;
    }

    public void retry() {
        addTrial();
        gameStatus = GameStatus.CONTINUE;
        bridgeMap = new BridgeMap();
    }
}
