package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeTestMapTest {
    @Test
    public void testGetBridgeMap() {
        MovingMap movingMap = new MovingMap();
        movingMap.add(GameStatus.CONTINUE, Side.UP);
        movingMap.add(GameStatus.CONTINUE, Side.DOWN);
        assertThat(movingMap.toString()).contains("O");
    }

    @Test
    public void testGetBridgeMap_실패_케이스() {
        MovingMap movingMap = new MovingMap();
        movingMap.add(GameStatus.CONTINUE, Side.UP);
        movingMap.add(GameStatus.FAIL, Side.DOWN);
        assertThat(movingMap.toString()).contains("?");
    }
}