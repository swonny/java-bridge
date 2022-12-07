package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultBoardTest {
    private final int INITIALIZED_TRIAL = 1;
    ResultBoard resultBoard;

    @BeforeEach
    public void setUp() {
        resultBoard = new ResultBoard(INITIALIZED_TRIAL, GameStatus.CONTINUE);
    }

    @ParameterizedTest
    @EnumSource(GameStatus.class)
    public void testUpdateResult(GameStatus gameStatus) {
        resultBoard.updateResult(gameStatus);
        assertThat(resultBoard.toString()).contains(
                "게임 성공 여부: ",
                "총 시도한 횟수: "
        );
        assertThat(resultBoard.toString()).contains(
                gameStatus.getPrintFormat()
        );
    }

    @Test
    public void testGetBridgeMap() {
//        ResultBoard resultBoard = new ResultBoard(-1, GameStatus.CONTINUE);
//        resultBoard.updateResult(GameStatus.CONTINUE, Side.UP);
//        resultBoard.updateResult(GameStatus.CONTINUE, Side.UP);
//        assertThat(resultBoard.getBridgeMap()).isEqualTo("a");
    }

    @Test
    public void testGetResult() {
//        ResultBoard resultBoard = new ResultBoard(1, GameStatus.CONTINUE);
//        resultBoard.updateResult(GameStatus.CONTINUE, Side.UP);
//        resultBoard.updateResult(GameStatus.CONTINUE, Side.UP);
//        assertThat(resultBoard.getResult()).isEqualTo("a");
    }
}