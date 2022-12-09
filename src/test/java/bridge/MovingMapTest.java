package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MovingMapTest {
    MovingMap movingMap = new MovingMap();

    @Test
    public void testAdd_진행중케이스() {
        movingMap.add(GameStatus.CONTINUE, Side.UP);
        assertThat(movingMap.toString()).contains(
                "[ O ]",
                "[   ]"
        );
    }

    @Test
    public void testAdd_실패케이스() {
        movingMap.add(GameStatus.FAIL, Side.UP);
        assertThat(movingMap.toString()).contains(
                "[ X ]",
                "[   ]"
        );
    }

    @Test
    public void testAdd_성공케이스() {
        movingMap.add(GameStatus.SUCCESS, Side.UP);
        assertThat(movingMap.toString()).contains(
                "[ O ]",
                "[   ]"
        );
    }

    @Test
    public void testAdd_성공케이스_3번시도() {
        movingMap.add(GameStatus.SUCCESS, Side.UP);
        movingMap.add(GameStatus.SUCCESS, Side.UP);
        movingMap.add(GameStatus.SUCCESS, Side.UP);
        assertThat(movingMap.toString()).contains(
                "[ O | O | O ]",
                "[   |   |   ]"
        );
    }

    @Test
    public void testAdd_실패케이스_3번시도() {
        movingMap.add(GameStatus.SUCCESS, Side.UP);
        movingMap.add(GameStatus.SUCCESS, Side.UP);
        movingMap.add(GameStatus.FAIL, Side.DOWN);
        assertThat(movingMap.toString()).contains(
                "[ O | O |   ]",
                "[   |   | X ]"
        );
    }

    @Test
    public void testAdd_위아래순서테스트() {
        movingMap.add(GameStatus.SUCCESS, Side.UP);
        movingMap.add(GameStatus.SUCCESS, Side.UP);
        movingMap.add(GameStatus.FAIL, Side.DOWN);
        assertThat(movingMap.toString().indexOf("[ O | O |   ]"))
                .isLessThan(movingMap.toString().indexOf("[   |   | X ]"));
    }

}