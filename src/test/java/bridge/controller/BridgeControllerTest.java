package bridge.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeControllerTest {
    @Test
    public void testStartGame() {
        BridgeController bridgeController = new BridgeController();
        bridgeController.startGame();
    }
}