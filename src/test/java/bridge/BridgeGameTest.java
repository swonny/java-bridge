package bridge;

import bridge.enums.Side;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testMove(int movings) {
        BridgeGame bridgeGame = new BridgeGame();
        for (int i = 0; i < movings; i++) {
            bridgeGame.move(Side.DOWN);
        }
        assertThat(bridgeGame.getPlayerPosition())
                .isEqualTo(movings - 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testGenerateBridge(int bridgeSize) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.makeBridge(bridgeSize);
    }
}