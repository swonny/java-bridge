package bridge;

import bridge.enums.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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
    public void testRetry_성공여부테스트() {
        resultBoard.updateResult(GameStatus.FAIL);
        assertThat(resultBoard.toString()).contains("실패");
        resultBoard.retry();
        assertThat(resultBoard.toString()).doesNotContain("실패");
    }

    @Test
    public void testRetry_시도횟수테스트() {
        assertThat(resultBoard.toString()).contains("총 시도한 횟수: 1");
        resultBoard.retry();
        assertThat(resultBoard.toString()).contains("총 시도한 횟수: 2");
    }
}