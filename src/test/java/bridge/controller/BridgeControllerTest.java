package bridge.controller;

import bridge.BridgeGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeControllerTest {
    @Test
    public void testStartGame() {
        BridgeController bridgeController = new BridgeController(new BridgeGame());
        bridgeController.startGame();
    }
}