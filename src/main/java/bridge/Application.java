package bridge;

import controller.BridgeController;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController(new OutputView());
        bridgeController.run();
    }
}
