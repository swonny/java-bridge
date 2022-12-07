package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;

public class ResultBoard {
    private final String NEW_LINE = "\n";
    private final String IS_WIN = "게임 성공 여부: ";
    private final String TRIAL = "총 시도한 횟수: ";

    private int trial;
    private GameStatus gameStatus;

    public ResultBoard(int initializedTrial, GameStatus gameStatus) {
        trial = initializedTrial;
        this.gameStatus = gameStatus;
    }

    public void updateResult(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
        // TODO : BridgeMap 업데이트 필요
//        updateMap(gameStatus, lastMoving);
    }

    public void retry() {
        addTrial();
        gameStatus = GameStatus.CONTINUE;
    }

    private void addTrial() {
        trial++;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        return result
                .append(IS_WIN)
                .append(gameStatus.getPrintFormat())
                .append(NEW_LINE)
                .append(TRIAL)
                .append(Integer.toString(trial))
                .toString();
    }
}
