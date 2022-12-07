package bridge.controller;

import bridge.BridgeGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeControllerTest extends NsTest {
    BridgeController bridgeController = new BridgeController(new BridgeGame());

    @Test
    public void testStartGame() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "U", "D", "U", "D");
            assertThat(output()).contains(
                    "[ O |   | O |   ]",
                    "[   | O |   | O ]"
            );
        }, 1, 0, 1, 0);
    }

    @Test
    public void testWillTry() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "U", "D", "U", "U", "R");
            assertThat(output()).contains(
                    "[ O |   | O | X ]",
                    "[   | O |   |   ]"
            );
        }, 1, 0, 1, 1);
    }

    @Override
    public void runMain() {
        bridgeController.startGame();
    }
}