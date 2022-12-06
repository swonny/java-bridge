package bridge;

import bridge.enums.GameStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgressBoardTest {
    @Test
    public void testUpdate() {
        ProgressBoard progressBoard = new ProgressBoard(-1, GameStatus.CONTINUE);
//        progressBoard.update(GameStatus.SUCCESS);
    }
}