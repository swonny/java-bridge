package bridge;

import bridge.enums.GameStatus;
import bridge.enums.Side;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMapTest {
    @Test
    public void testGetBridgeMap() {
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.add(GameStatus.CONTINUE, Side.UP);
        bridgeMap.add(GameStatus.CONTINUE, Side.DOWN);
        assertThat(bridgeMap.getBridgeMap()).contains("O");
    }

    @Test
    public void testGetBridgeMap_실패_케이스() {
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.add(GameStatus.CONTINUE, Side.UP);
        bridgeMap.add(GameStatus.FAIL, Side.DOWN);
        assertThat(bridgeMap.getBridgeMap()).contains("?");
    }
}