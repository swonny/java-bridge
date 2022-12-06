package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProgressBoardTest {
    @Test
    public void testUpdate() {
        ProgressBoard progressBoard = new ProgressBoard(-1, GameStatus.CONTINUE);
    }

    @Test
    public void testGetBridgeMap() {
        ProgressBoard progressBoard = new ProgressBoard(-1, GameStatus.CONTINUE);
        progressBoard.update(GameStatus.CONTINUE, Side.UP);
        progressBoard.update(GameStatus.CONTINUE, Side.UP);
        assertThat(progressBoard.getBridgeMap()).isEqualTo("a");
    }

    @Test
    public void testGetResult() {
        ProgressBoard progressBoard = new ProgressBoard(1, GameStatus.CONTINUE);
        progressBoard.update(GameStatus.CONTINUE, Side.UP);
        progressBoard.update(GameStatus.CONTINUE, Side.UP);
        assertThat(progressBoard.getResult()).isEqualTo("a");
    }
}